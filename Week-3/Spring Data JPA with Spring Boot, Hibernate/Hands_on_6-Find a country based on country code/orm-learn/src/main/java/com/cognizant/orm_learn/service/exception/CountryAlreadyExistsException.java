package com.cognizant.orm_learn.service.exception;

public class CountryAlreadyExistsException extends Exception  {
	public CountryAlreadyExistsException(String message) {
        super(message);
    }
}
