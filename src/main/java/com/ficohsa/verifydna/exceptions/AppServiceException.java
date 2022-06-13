package com.ficohsa.verifydna.exceptions;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(BAD_REQUEST)
public class AppServiceException extends RuntimeException {
	private static final long serialVersionUID = -5088929993108857270L;

	public AppServiceException(String message) {
		super(message);
	}
}
