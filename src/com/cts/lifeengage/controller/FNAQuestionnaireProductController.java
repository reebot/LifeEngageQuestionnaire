package com.cts.lifeengage.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cts.lifeengage.bo.FNAQuestionnaireBo;
import com.cts.lifeengage.exception.FNAException;
import com.cts.lifeengage.model.FNAProductTo;
import com.cts.lifeengage.model.FNARiskTo;


public class FNAQuestionnaireProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FNAQuestionnaireProductController() {
        super();
       
    }

	//Calculation of Recommended Product	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=null;
		RequestDispatcher dispatcher=null;
		FNAQuestionnaireBo productbo=new FNAQuestionnaireBo();
		FNAProductTo productinfo=new FNAProductTo();
		try{
		StringBuffer sb=new StringBuffer();
		String stringname="product",productstring=null,productvalue;
		int stringnumber=0,index,total;
	
		total=Integer.parseInt(request.getParameter("total"));
		productinfo.setTotal(total);
		
		String[] optionslocal=new String[total];
		
		for(index=0;index<total;index++)
		{
		
		sb.delete(0,sb.length());
		sb.append(stringname).append(stringnumber);
		stringnumber++;
		productstring=sb.toString();
		productvalue=request.getParameter(productstring);
		
		optionslocal[index]=productvalue;
		
		}
		productinfo.setOptions(optionslocal);
		productinfo.setCustid(request.getParameter("custid"));
		
		if(productbo.calculateProduct(productinfo));
		{	
			session=request.getSession(true);
			session.setAttribute("PREFERREDPRODUCT",productinfo);
			dispatcher=request.getRequestDispatcher("./Team3_Start.jsp"); 
			dispatcher.forward(request, response);	
		}
		}catch (FNAException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	
	}

}
