package com.cts.lifeengage.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cts.lifeengage.dao.FNAQuestionnaireDao;
import com.cts.lifeengage.exception.FNAException;
import com.cts.lifeengage.model.FNAProductFormTo;
import com.cts.lifeengage.model.FNAProductTo;
import com.cts.lifeengage.model.FNARiskFormTo;
import com.cts.lifeengage.model.FNARiskTo;

public class FNAQuestionnaireBo {
	FNAQuestionnaireDao formdao=new FNAQuestionnaireDao();
	
	//Retrieval of Risk Questionnaire 
	public ArrayList<FNARiskFormTo> retrieveRiskForm() throws FNAException {
		return formdao.retrieveRiskForm();
	}

	//Retrieval of Product Questionnaire 
	public ArrayList<FNAProductFormTo> retrieveProductForm() throws FNAException {
		return formdao.retrieveProductForm();
		
	}

	//Calculation of Risk Profile
	public boolean calculateRisk(FNARiskTo riskinfo) throws FNAException {
		 return formdao.calculateRisk(riskinfo);
		
	}

	//Calculation of Recommended Product
	public boolean calculateProduct(FNAProductTo productinfo) throws FNAException, SQLException {
		 return formdao.calculateProduct(productinfo);
	}

}
