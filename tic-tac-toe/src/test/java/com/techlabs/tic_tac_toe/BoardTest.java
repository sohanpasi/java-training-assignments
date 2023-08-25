package com.techlabs.tic_tac_toe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BoardTest {

	Board gameBoard;
	@BeforeEach
	void init() {
		gameBoard = new Board(3);
	}

	@Test
	void testIsFreeCell() {
	
		assertTrue(gameBoard.isFreeCells());
		
		Cell cellMarkType = new Cell(MarkType.O);
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				gameBoard.markCell(i, j, cellMarkType);
			}
		}
		
		assertFalse(gameBoard.isFreeCells());
	}
	
	@Test
	void testMarkShell() {
		Cell cellMarkType = new Cell(MarkType.O);
		assertThrows(InvalidLocationException.class, ()->gameBoard.markCell(3, 3, cellMarkType));

		gameBoard.markCell(2, 2, cellMarkType);
		assertThrows(CellAlreadyMarkedException.class, ()->gameBoard.markCell(2, 2, cellMarkType));		
	}

}
