package com.cts.lifeengage.exception;

public class FNAException extends Exception {
	public FNAException (String errormessage){
		 super(errormessage);
	 }
	 
	 public FNAException (String errormessage, Throwable t){
		 super(errormessage,t);
	 }

	public FNAException() {
		
	}
}
