package com.shoppingcart.project.app.exception;

public class OrderNotFoundException extends Exception {

	
	private static final long serialVersionUID = -2128469276463517770L;

	public OrderNotFoundException(String message) {
		super (message);
	}
}
