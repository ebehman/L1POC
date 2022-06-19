package com.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final String resourceName;
	final String fieldname;
	final Long fieldValue;
	
	public ResourceNotFoundException(String resourceName, String fieldname, Long fieldValue) {
		super(String.format("%s not found with %s : '%s'",resourceName,fieldname,fieldValue));
		this.resourceName = resourceName;
		this.fieldname = fieldname;
		this.fieldValue = fieldValue;
	}
	
}
