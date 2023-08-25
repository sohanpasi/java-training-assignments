package com.techlabs.tic_tac_toe;

public class Cell {

	private MarkType markType;

	// constructor
	public Cell(MarkType markType) {
		this.markType = markType;
	}
	
	// Getters and Setters
	public MarkType getMarkType() {
		return markType;
	}

	public void setMarkType(MarkType markType) {
		this.markType = markType;
	}

}
