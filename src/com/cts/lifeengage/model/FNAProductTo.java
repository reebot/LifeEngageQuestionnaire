package com.cts.lifeengage.model;

import java.io.Serializable;

public class FNAProductTo implements Serializable{
	private String question;
	private String[] answer;
	private String riskprofile;
	private String productrecommended;
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
	public String getRiskprofile() {
		return riskprofile;
	}
	public void setRiskprofile(String riskprofile) {
		this.riskprofile = riskprofile;
	}
	
	
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}

	public String[] getAnswer() {
		return answer;
	}
	public void setAnswer(String[] answer) {
		this.answer = answer;
	}

	public String getProductrecommended() {
		return productrecommended;
	}
	public void setProductrecommended(String productrecommended) {
		this.productrecommended = productrecommended;
	}
	
}
