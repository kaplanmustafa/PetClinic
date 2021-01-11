package com.mustafakaplan.petclinic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1473259322940911306L;

	public InternalServerException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
}
