package com.cts.lifeengage.model;

import java.io.Serializable;

public class FNAProductFormTo implements Serializable{
private String productquestions;
private String productoptions;
private String preferredproduct;

public FNAProductFormTo(String productquestions, String productoptions,String preferredproduct) {
	this.productquestions = productquestions;
	this.productoptions = productoptions;
	this.preferredproduct = preferredproduct;
}
public String getProductquestions() {
	return productquestions;
}
public void setProductquestions(String productquestions) {
	this.productquestions = productquestions;
}
public String getProductoptions() {
	return productoptions;
}
public void setProductoptions(String productoptions) {
	this.productoptions = productoptions;
}
public String getPreferredproduct() {
	return preferredproduct;
}
public void setPreferredproduct(String preferredproduct) {
	this.preferredproduct = preferredproduct;
}


}
