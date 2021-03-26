package com.synechron.wordcounter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(value = IllegalArgumentException.class)
	public ResponseEntity<ExceptionTranslator> translateValidationException(IllegalArgumentException ex, WebRequest request) {

		ExceptionTranslator e = new ExceptionTranslator();
		e.setMessage(ex.getMessage());
		e.setStatus(HttpStatus.BAD_REQUEST);
		e.setName(ex.getClass().getName());
		e.setStackTrace(ex.getStackTrace().toString());

		return new ResponseEntity<ExceptionTranslator>(e, HttpStatus.BAD_REQUEST);
	}
}
