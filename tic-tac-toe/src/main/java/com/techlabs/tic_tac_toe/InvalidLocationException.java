package com.techlabs.tic_tac_toe;

public class InvalidLocationException extends RuntimeException{

	public InvalidLocationException(String message) {
		super(message);
	}
}
