package com.example.movies.Exception;

public class RatingExceptions extends RuntimeException {

	private static final long serialVersionUID = 1L;
public RatingExceptions() {
		
	}
	public RatingExceptions(String message) {
		super(message);
	}
}
