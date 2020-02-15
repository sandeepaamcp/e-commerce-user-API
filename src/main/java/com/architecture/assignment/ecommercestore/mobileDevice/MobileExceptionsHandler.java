package com.architecture.assignment.ecommercestore.mobileDevice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MobileExceptionsHandler
		extends ResponseEntityExceptionHandler
{

	@ExceptionHandler(value
			= { MobileNotFoundException.class })
	protected ResponseEntity<Object> handleConflict(
			RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "The requested mobile is not found.";
		return handleExceptionInternal(ex, bodyOfResponse,
				new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
}
