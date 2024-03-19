package org.jsp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(MerchantNotFoundException.class)
	public ResponseEntity<String> handleProductNotFoundException(MerchantNotFoundException exception) {
		String msg = "Merchant Not Found";
		return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException exception) {
		String msg = "Product Not Found";
		return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
	}
}
