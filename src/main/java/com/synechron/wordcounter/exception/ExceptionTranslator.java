package com.synechron.wordcounter.exception;

import org.springframework.http.HttpStatus;

public class ExceptionTranslator {

	private String name;

	private String message;

	private String stackTrace;

	private HttpStatus status;

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}

	public ExceptionTranslator() {
		super();
	}

	@Override
	public String toString() {
		return String.format("ExceptionTranslator [name=%s, message=%s, stackTrace=%s]", name, message, stackTrace);
	}

}
