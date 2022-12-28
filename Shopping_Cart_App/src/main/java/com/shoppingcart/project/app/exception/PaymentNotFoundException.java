package com.shoppingcart.project.app.exception;

public class PaymentNotFoundException extends Exception {

	private static final long serialVersionUID = -4703607524273407511L;

	public PaymentNotFoundException(String message) {
		super (message);
	}
}

