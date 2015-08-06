package com.cts.lifeengage.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class FNARiskTo implements Serializable{
	
	private int[] answer;
	private int sum;
	private String riskprofile;
	private String custid;
	private String[] options;
	private int total;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String[] getOptions() {
		return options;
	}
	public void setOptions(String[] options) {
		this.options = options;
	}
	HashMap<String,String> custanswer=new HashMap<String, String>();

	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	
	
	public HashMap<String, String> getCustanswer() {
		return custanswer;
	}
	public void setCustanswer(HashMap<String, String> custanswer) {
		this.custanswer = custanswer;
	}

	public String getRiskprofile() {
		return riskprofile;
	}
	public void setRiskprofile(String riskprofile) {
		this.riskprofile = riskprofile;
	}
	public int[] getAnswer() {
		return answer;
	}
	public void setAnswer(int[] answer) {
		this.answer = answer;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	
	
}
