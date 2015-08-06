package com.cts.lifeengage.model;

import java.io.Serializable;
import java.util.ArrayList;



public class FNARiskFormTo implements Serializable{
private String riskquestions;
private String riskoptions;
private int weightage;




public FNARiskFormTo(String riskquestions, String riskoptions,int weightage) {
	this.riskquestions = riskquestions;
	this.riskoptions = riskoptions;
	this.weightage = weightage;

}

public FNARiskFormTo() {
	
}

public String getRiskquestions() {
	return riskquestions;
}

public void setRiskquestions(String riskquestions) {
	this.riskquestions = riskquestions;
}

public String getRiskoptions() {
	return riskoptions;
}

public void setRiskoptions(String riskoptions) {
	this.riskoptions = riskoptions;
}

public int getWeightage() {
	return weightage;
}

public void setWeightage(int weightage) {
	this.weightage = weightage;
}


}
