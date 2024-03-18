package org.jsp.exception;

public class MerchantNotFoundException extends RuntimeException{
	public MerchantNotFoundException(String msg) {
		super(msg);
	}
}
