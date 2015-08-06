package com.cts.lifeengage.constants;

public class FNAQueryConstants {

	public static final String QRY_RISK_INFO = "select questions,options,weightage from risk_profile_questionnaire";
	public static final String QRY_PRODUCT_INFO ="select questions,answers,preferred_product from product_questionnaire" ;
	
	public static final String QRY_CUSTPRODUCTOPTION_INSERT = "insert into product_selected values(?,?)";
	public static final String QRY_SELECTPRODUCT_INFO = "select questions,answers,preferred_product from product_questionnaire where preferred_product in (select productoptions from product_selected where customer_id=?) group by questions";
	public static final String QRY_INSERT_PRODUCTINFO = "insert into product_answers values(?,?,?,?)";
	public static final String QRY_PREFERREDPRODUCT_INFO = " select distinct recommended_product from product_recommendation where risk_profile in (select risk_profile from risk_profile where customer_id=?) and preferred_product in (select productoptions from product_selected where customer_id=?) and goal in (select goal from analysis_summary where CustomerID=?)";
	public static final String QRY_INSERT_PREFERREDPRODUCT = "insert into recommended_product values(?,?)";
	
	
	public static final String QRY_CUSTRISKOPTION_INSERT ="insert into risk_selected values(?,?)";
	public static final String QRY_SELECTRISK_INFO = "select questions,options,weightage from risk_profile_questionnaire where options in (select riskoptions from risk_selected where customer_id=?)";
	public static final String QRY_INSERT_RISKINFO = "insert into risk_answers values(?,?,?,?)";
	public static final String QRY_RISKANALYSIS_INFO =" select risk_profile from risk_calculation where sum_of_weightage=?";
	public static final String QRY_RISKPROFILE_INSERT ="insert into risk_profile values(?,?)";
	
	

}
