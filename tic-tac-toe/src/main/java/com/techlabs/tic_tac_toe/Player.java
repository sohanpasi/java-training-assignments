package com.techlabs.tic_tac_toe;

public class Player {

	private String name;
	private Cell cellMarkType;
	
	// constructor
	public Player(String name, Cell cellMarkType) {
		this.name = name;
		this.cellMarkType = cellMarkType;
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Cell getCellMarkType() {
		return cellMarkType;
	}

	public void setCellMarkType(Cell cellMarkType) {
		this.cellMarkType = cellMarkType;
	}

}
