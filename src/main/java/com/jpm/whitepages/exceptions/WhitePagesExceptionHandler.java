package com.jpm.whitepages.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class WhitePagesExceptionHandler  extends ResponseEntityExceptionHandler {

	@ExceptionHandler(WhitePagesFailureException.class)
	public ResponseEntity<WhitePagesErrorResponse> handleFailure(Exception ex, WebRequest request) {
		WhitePagesErrorResponse errors = new WhitePagesErrorResponse(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ExceptionHandler(WhitePagesTimeoutException.class)
	public ResponseEntity<WhitePagesErrorResponse> handleTimeout(Exception ex, WebRequest request) {
		WhitePagesErrorResponse errors = new WhitePagesErrorResponse(LocalDateTime.now(), HttpStatus.GATEWAY_TIMEOUT.value(), ex.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.GATEWAY_TIMEOUT);
    }

}
