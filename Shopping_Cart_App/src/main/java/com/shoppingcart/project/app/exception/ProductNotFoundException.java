package com.shoppingcart.project.app.exception;

public class ProductNotFoundException extends Exception{
	
	
	private static final long serialVersionUID = 1032948742848187450L;

	public ProductNotFoundException(String message) {
		super (message);
	}
}
