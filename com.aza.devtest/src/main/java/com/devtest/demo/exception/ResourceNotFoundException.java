package com.devtest.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resourceName;
	private String name;
	private String value;
	public ResourceNotFoundException(String resourceName, String name, String value) {
		super(String.format("%s data not found. %s = '%s'", resourceName,name,value));
		this.resourceName = resourceName;
		this.name = name;
		this.value = value;
	}
	
	public String getResourceName() {
		return resourceName;
	}
	
	public String getName() {
		return name;
	}
	
	public String getValue() {
		return value;
	}
}
