package com.codewithdurgesh.blogexceptions;

public class ApiException extends RuntimeException{

	public ApiException(String message) {
		super(message);
	}

	public ApiException() {
		super();
	}
	
	

}
