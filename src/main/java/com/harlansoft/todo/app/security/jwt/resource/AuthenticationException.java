package com.harlansoft.todo.app.security.jwt.resource;

public class AuthenticationException extends RuntimeException {

	private static final long serialVersionUID = 6637159148805679324L;

	public AuthenticationException(String message, Throwable cause) {
		super(message, cause);
	}
}
