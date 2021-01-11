package com.mustafakaplan.petclinic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class OwnerNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 95936855601021462L;

	public OwnerNotFoundException(String message) {
		super(message);
	}
}
