package com.techlabs.tic_tac_toe;

public class CellAlreadyMarkedException extends RuntimeException{

	public CellAlreadyMarkedException(String message) {
		super(message);
	}
}
