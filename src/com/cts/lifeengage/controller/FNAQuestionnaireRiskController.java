package com.cts.lifeengage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cts.lifeengage.bo.FNAQuestionnaireBo;
import com.cts.lifeengage.exception.FNAException;
import com.cts.lifeengage.model.FNARiskFormTo;
import com.cts.lifeengage.model.FNARiskTo;


public class FNAQuestionnaireRiskController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FNAQuestionnaireRiskController() {
        super();
       
    }

	
	//Calculation of Risk Profile
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=null;
		RequestDispatcher dispatcher=null;
		FNAQuestionnaireBo riskbo=new FNAQuestionnaireBo();
		FNARiskTo riskinfo=new FNARiskTo();
		try{
		HashMap<String,String> custanswerlocal=new HashMap<String, String>();
		StringBuffer sb=new StringBuffer();
		String stringname="risk",riskstring=null,riskvalue;
		
		int stringnumber=0,index,total;
		total=Integer.parseInt(request.getParameter("total"));
		riskinfo.setTotal(total);
		String[] optionslocal=new String[total];
		
		for(index=0;index<total;index++)
		{
		sb.delete(0,sb.length());
		sb.append(stringname).append(stringnumber);
		stringnumber++;
		riskstring=sb.toString();
		
		riskvalue=(request.getParameter(riskstring));
		optionslocal[index]=riskvalue;
		custanswerlocal.put(riskstring, riskvalue);
		}  
		
		riskinfo.setOptions(optionslocal);
		
		riskinfo.setCustid(request.getParameter("custid"));
		riskinfo.setCustanswer(custanswerlocal);
		
		if(riskbo.calculateRisk(riskinfo));
		{	
			session=request.getSession(true);
			session.setAttribute("RISKPROFILE",riskinfo);
			
			dispatcher=request.getRequestDispatcher("./RiskSummary.jsp"); 
			dispatcher.forward(request, response);	
		}
		}catch (FNAException e) {
			
			e.printStackTrace();
		}
		

			
		
	}

}
