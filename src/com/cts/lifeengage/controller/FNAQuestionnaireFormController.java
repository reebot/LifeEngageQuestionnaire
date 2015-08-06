package com.cts.lifeengage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cts.lifeengage.bo.FNAQuestionnaireBo;
import com.cts.lifeengage.exception.FNAException;
import com.cts.lifeengage.model.FNAProductFormTo;
import com.cts.lifeengage.model.FNARiskFormTo;


public class FNAQuestionnaireFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FNAQuestionnaireFormController() {
        super();
        
    }
    //Questionnaire Population
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher=null;
		ArrayList<FNARiskFormTo> riskform=null;
		ArrayList<FNAProductFormTo> productform=null;
	
		FNAQuestionnaireBo formbo=new FNAQuestionnaireBo();
		try{
			riskform=formbo.retrieveRiskForm();				
			productform=formbo.retrieveProductForm();		
			HttpSession session=request.getSession(true);
			session.setAttribute("RISK",riskform);
			session.setAttribute("PRODUCT",productform);
			
			dispatcher=request.getRequestDispatcher("./Risk_Questionnaire.jsp");
			dispatcher.forward(request, response);
		}catch (FNAException e) {
			
			e.printStackTrace();
		}
	}

}
