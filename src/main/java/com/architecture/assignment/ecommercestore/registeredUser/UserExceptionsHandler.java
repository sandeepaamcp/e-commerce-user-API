package com.architecture.assignment.ecommercestore.registeredUser;

import com.architecture.assignment.ecommercestore.partnerDealerShop.DealerNotAvailableException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class UserExceptionsHandler extends ResponseEntityExceptionHandler
{

	@ExceptionHandler(value
			= { UserServiceException.class })
	protected ResponseEntity<Object> handleConflict(
			RuntimeException ex, WebRequest request )
	{
		String bodyOfResponse = ex.getMessage();
		return handleExceptionInternal( ex, bodyOfResponse,
				new HttpHeaders(), HttpStatus.BAD_REQUEST, request );
	}
}
