package com.techlabs.tic_tac_toe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;

class TicTacToeGameTest {

	TicTacToeGame game;
	Board gameBoard = Mockito.mock(Board.class);
	
	@BeforeEach
	void inti() {
		game = new TicTacToeGame();
		gameBoard = new Board(3);
	}

	
	@Test
	void testCheckRowWinner() 
	{	
		game.setGameBoard(gameBoard);
		assertFalse(game.checkRowWinner(0, 1, MarkType.O));
		
		Cell cellMarkType = Mockito.mock(Cell.class);
		Mockito.when(cellMarkType.getMarkType()).thenReturn(MarkType.O);
		
		gameBoard.markCell(0, 0, cellMarkType);
		gameBoard.markCell(0, 1, cellMarkType);
		gameBoard.markCell(0, 2, cellMarkType);
		assertTrue(game.checkRowWinner(0, 1, MarkType.O));
	}
	
	@Test
	void testCheckColumnWinner() 
	{	
		game.setGameBoard(gameBoard);
		assertFalse(game.checkColumnWinner(1, 1, MarkType.O));

		Cell cellMarkType = Mockito.mock(Cell.class);
		Mockito.when(cellMarkType.getMarkType()).thenReturn(MarkType.O);
		
		gameBoard.markCell(0, 1, cellMarkType);
		gameBoard.markCell(1, 1, cellMarkType);
		gameBoard.markCell(2, 1, cellMarkType);
		assertTrue(game.checkColumnWinner(2, 1, MarkType.O));
	}
	
	@Test
	void testCheckLeftDiagonalWinner() 
	{	
		game.setGameBoard(gameBoard);
		assertFalse(game.checkLeftDiagonalWinner(1, 1, MarkType.O));

		Cell cellMarkType = Mockito.mock(Cell.class);
		Mockito.when(cellMarkType.getMarkType()).thenReturn(MarkType.O);
		
		gameBoard.markCell(0, 0, cellMarkType);
		gameBoard.markCell(1, 1, cellMarkType);
		gameBoard.markCell(2, 2, cellMarkType);
		assertTrue(game.checkLeftDiagonalWinner(2, 2, MarkType.O));
	}
	
	@Test
	void TestCheckRightDiagonalWinner() 
	{	
		game.setGameBoard(gameBoard);
		assertFalse(game.checkRightDiagonalWinner(1, 1, MarkType.O));

		Cell cellMarkType = Mockito.mock(Cell.class);
		Mockito.when(cellMarkType.getMarkType()).thenReturn(MarkType.O);
		
		gameBoard.markCell(0, 2, cellMarkType);
		gameBoard.markCell(1, 1, cellMarkType);
		gameBoard.markCell(2, 0, cellMarkType);
		assertTrue(game.checkRightDiagonalWinner(2, 0, MarkType.O));
	}
	
}
