package com.cts.lifeengage.dao;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.cts.lifeengage.constants.FNAQueryConstants;
import com.cts.lifeengage.exception.FNAException;
import com.cts.lifeengage.model.FNAProductFormTo;
import com.cts.lifeengage.model.FNAProductTo;
import com.cts.lifeengage.model.FNARiskFormTo;
import com.cts.lifeengage.model.FNARiskTo;
import com.cts.lifeengage.util.FNADbUtil;


public class FNAQuestionnaireDao {

	//Retrieval of Risk Questionnaire 
	public ArrayList<FNARiskFormTo> retrieveRiskForm() throws FNAException {
		Connection connection=null;
		ResultSet result=null;
		Statement statement=null;
		ArrayList<FNARiskFormTo> risklist=null;
		
		
		try{
			connection=FNADbUtil.getConnection();
			statement=connection.createStatement();
			result=statement.executeQuery(FNAQueryConstants.QRY_RISK_INFO);
			risklist=new ArrayList<FNARiskFormTo>();
			
			while(result.next())
			{	
				String question=result.getString(1);
				String option=result.getString(2);
				String weight=result.getString(3);
				int weightage=Integer.parseInt(weight);
								
				risklist.add(new FNARiskFormTo(question,option,weightage));
				
			}
		} catch (ClassNotFoundException e) {
			throw new FNAException("driver not found", e);
		}  catch(NullPointerException e)
		{
			throw new FNAException("Null pointer error", e);
		}catch (SQLException e) {
			throw new FNAException("Database error", e);
		}
		return risklist;
	}

	//Retrieval of Product Questionnaire 
	public ArrayList<FNAProductFormTo> retrieveProductForm() throws FNAException {
		Connection connection=null;
		ResultSet result=null;
		Statement statement=null;
		ArrayList<FNAProductFormTo> productlist=null;
		try{
			connection=FNADbUtil.getConnection();
			statement=connection.createStatement();
			result=statement.executeQuery(FNAQueryConstants.QRY_PRODUCT_INFO);
			productlist=new ArrayList<FNAProductFormTo>();
			while(result.next())
			{
				String question=result.getString(1);
				String option=result.getString(2);
				String preferredproduct=result.getString(3);
				productlist.add(new FNAProductFormTo(question,option,preferredproduct));
				
			}
		} catch (ClassNotFoundException e) {
			throw new FNAException("driver not found", e);
		} catch(NullPointerException e)
		{
			throw new FNAException("Null pointer error", e);
		}catch (SQLException e) {
			throw new FNAException("Database error", e);
		}
		return productlist;
	}

	//Calculation of Risk Profile
	public boolean calculateRisk(FNARiskTo riskinfo) throws FNAException {
		Connection connection=null;
		ResultSet selectriskresult=null;
		ResultSet selectriskprofileresult=null;
		java.sql.PreparedStatement insertoptionstatement=null;
		java.sql.PreparedStatement selectriskinfostatement=null;
		java.sql.PreparedStatement insertcustriskinfostatement=null;
		java.sql.PreparedStatement selectriskprofilestatement=null;
		java.sql.PreparedStatement insertriskprofilestatement=null;
		
		
		int sum=0;
		boolean flag=false;
		try{
			String[] options=riskinfo.getOptions();
			connection=FNADbUtil.getConnection();
			insertoptionstatement=connection.prepareStatement(FNAQueryConstants.QRY_CUSTRISKOPTION_INSERT);
			for(int i=0;i<riskinfo.getTotal();i++)
			{
				insertoptionstatement.setString(1,riskinfo.getCustid());
				insertoptionstatement.setString(2,options[i]);
				insertoptionstatement.executeUpdate();
			}
			
			selectriskinfostatement=connection.prepareStatement(FNAQueryConstants.QRY_SELECTRISK_INFO);
			selectriskinfostatement.setString(1,riskinfo.getCustid());
			selectriskresult=selectriskinfostatement.executeQuery();
			
			while(selectriskresult.next())
			{
				String question=selectriskresult.getString(1);
				String answer=selectriskresult.getString(2);
				String weightage=selectriskresult.getString(3);
				insertcustriskinfostatement=connection.prepareStatement(FNAQueryConstants.QRY_INSERT_RISKINFO);
				insertcustriskinfostatement.setString(1,riskinfo.getCustid());
				insertcustriskinfostatement.setString(2,question);
				insertcustriskinfostatement.setString(3,answer);
				insertcustriskinfostatement.setInt(4,Integer.parseInt(weightage));
				insertcustriskinfostatement.executeUpdate();
				sum+=Integer.parseInt(weightage);
			}
		
	
			riskinfo.setSum(sum);
			String riskprofile=null;
			
			selectriskprofilestatement=connection.prepareStatement(FNAQueryConstants.QRY_RISKANALYSIS_INFO);
			selectriskprofilestatement.setInt(1,riskinfo.getSum());
			selectriskprofileresult=selectriskprofilestatement.executeQuery();
			if (selectriskprofileresult.next() == true) 
			{
				riskprofile=selectriskprofileresult.getString(1);
				flag=true;
			}
			riskinfo.setRiskprofile(riskprofile);
			
			insertriskprofilestatement=connection.prepareStatement(FNAQueryConstants.QRY_RISKPROFILE_INSERT);
			insertriskprofilestatement.setString(1,riskinfo.getCustid());
			insertriskprofilestatement.setString(2,riskinfo.getRiskprofile());
			insertriskprofilestatement.executeUpdate();
			
			
		}catch (ClassNotFoundException e) {
			throw new FNAException("driver not found", e);
		} catch(NullPointerException e)
		{
			throw new FNAException("Null pointer error", e);
		}catch (SQLException e) {
			throw new FNAException("Database error", e);
		}
		return flag;
		
		
	}

	//Calculation of Recommended Product
	public boolean calculateProduct(FNAProductTo productinfo) throws FNAException{
		Connection connection=null;
		ResultSet selectproductresult=null;
		ResultSet selectrecommendedproductresult=null;
		java.sql.PreparedStatement insertoptionstatement=null;
		java.sql.PreparedStatement selectproductinfostatement=null;
		java.sql.PreparedStatement insertcustproductinfostatement=null;
		java.sql.PreparedStatement selectrecommendedproductstatement=null;
		java.sql.PreparedStatement insertrecommendedproductstatement=null;
			
		boolean flag=false;
		try{
			String[] options=productinfo.getOptions();
			connection=FNADbUtil.getConnection();
			insertoptionstatement=connection.prepareStatement(FNAQueryConstants.QRY_CUSTPRODUCTOPTION_INSERT);
			for(int i=0;i<productinfo.getTotal();i++)
			{
				insertoptionstatement.setString(1,productinfo.getCustid());
				insertoptionstatement.setString(2,options[i]);
				insertoptionstatement.executeUpdate();
			}
			
			selectproductinfostatement=connection.prepareStatement(FNAQueryConstants.QRY_SELECTPRODUCT_INFO);
			selectproductinfostatement.setString(1,productinfo.getCustid());
			selectproductresult=selectproductinfostatement.executeQuery();
			
			while(selectproductresult.next())
			{
				String question=selectproductresult.getString(1);
				String answer=selectproductresult.getString(2);
				String preferredproduct=selectproductresult.getString(3);
			
				insertcustproductinfostatement=connection.prepareStatement(FNAQueryConstants.QRY_INSERT_PRODUCTINFO);
				insertcustproductinfostatement.setString(1,productinfo.getCustid());
				insertcustproductinfostatement.setString(2,question);
				insertcustproductinfostatement.setString(3,answer);
				insertcustproductinfostatement.setString(4,preferredproduct);
				insertcustproductinfostatement.executeUpdate();
				
			}
		
			selectrecommendedproductstatement=connection.prepareStatement(FNAQueryConstants.QRY_PREFERREDPRODUCT_INFO);
			selectrecommendedproductstatement.setString(1,productinfo.getCustid());
			selectrecommendedproductstatement.setString(2,productinfo.getCustid());			
			selectrecommendedproductstatement.setString(3,productinfo.getCustid());
			selectrecommendedproductresult=selectrecommendedproductstatement.executeQuery();
			
			while(selectrecommendedproductresult.next() == true) 
			{
				String product=selectrecommendedproductresult.getString(1);
				
				insertrecommendedproductstatement=connection.prepareStatement(FNAQueryConstants.QRY_INSERT_PREFERREDPRODUCT);
				insertrecommendedproductstatement.setString(1,productinfo.getCustid());
				insertrecommendedproductstatement.setString(2,product);
				insertrecommendedproductstatement.executeUpdate();
				
				flag=true;
			}
		}catch (ClassNotFoundException e) {
			throw new FNAException("driver not found", e);
		} catch(NullPointerException e)
		{
			throw new FNAException("Null pointer error", e);
		}catch (SQLException e) {
			throw new FNAException("Database error", e);
		}
		return flag;
		
		
	}
}
