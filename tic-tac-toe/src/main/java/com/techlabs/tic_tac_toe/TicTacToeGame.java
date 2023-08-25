package com.techlabs.tic_tac_toe;

import java.util.Scanner;

public class TicTacToeGame {

	private Player currentPlayer;
	private Player[] players = new Player[2];
	private Board gameBoard;
	
	Scanner scanner = new Scanner(System.in);
	
	public void setUpGame() 
	{	
		Cell mark1, mark2;
		System.out.print("Enter Board size: ");
		int boardSize = scanner.nextInt();
		gameBoard = new Board(boardSize);
		
		System.out.print("Enter Player1 Name: ");
		String person1 = scanner.next();
		System.out.print("Enter Player2 Name: ");
		String person2 = scanner.next();
		System.out.print("Enter Player1 Symbol: ");
		String symbol1 = scanner.next();
		if(symbol1.equalsIgnoreCase("X")){
			mark1=new MarkX();
			mark2=new MarkO();
		}
		else {
			mark1=new MarkO();
			mark2=new MarkX();
		}
		players[0] = new Player(person1, mark1);
		players[1] = new Player(person2, mark2);
		currentPlayer = players[0];
	}
	
	public void play() 
	{
		boolean winner = false;
		while(!winner) 
		{
			gameBoard.printBoard();
			boolean freeCell = gameBoard.isFreeCells();
			if(!freeCell) {														// freeCell == false
				System.out.println("--------- Tri!!! No Wins -----------");
				return;
			}
			
			System.out.println("Turn: "+currentPlayer.getName());
			System.out.print("Enter location to mark cell(Row Column): ");		// read location to mark cell
			int row = scanner.nextInt();
			int column = scanner.nextInt();
			
			try {
				gameBoard.markCell(row, column, currentPlayer.getCellMarkType());
			}
			
			catch(InvalidLocationException | CellAlreadyMarkedException e) {
				System.out.println(e.getMessage());
				continue;
			}
			
			winner = isAnyWinner(row, column, currentPlayer.getCellMarkType().getMarkType()); 
			if(winner) {
				gameBoard.printBoard();
				System.out.println("\n--------Winner-------- "+currentPlayer.getName()); 
			}
			switchPlayer();
		}
	}
	
	public boolean isAnyWinner(int row, int column, MarkType markType) 
	{
		return checkRowWinner(row, column, markType) || checkColumnWinner(row, column, markType) || checkLeftDiagonalWinner(row, column, markType) || checkRightDiagonalWinner(row, column, markType);
	}

	public boolean checkRowWinner(int row, int column, MarkType markType) 		// row checking
	{	
		boolean match = true;
		
		for(int i=0; i<gameBoard.getSize(); i++) {			
			if(gameBoard.getBoard()[row][i] == null || gameBoard.getBoard()[row][i].getMarkType() != markType) {
				match = false;
				break;
			}	
		}
		return match;
	}
	
	public boolean checkColumnWinner(int row, int column, MarkType markType) 	// column checking
	{	
		boolean match = true;
		
		for(int i=0; i<gameBoard.getSize(); i++) {
			if(gameBoard.getBoard()[i][column] == null || gameBoard.getBoard()[i][column].getMarkType() != markType) {
				match = false;
				break;
			}
		}
		return match;
	}
	
	public boolean checkLeftDiagonalWinner(int row, int column, MarkType markType) 	// left_top to bottom_right checking
	{	
		boolean match = true;
		
		for(int i=0, j=0; i<gameBoard.getSize(); i++, j++) {
			if(gameBoard.getBoard()[i][j] == null || gameBoard.getBoard()[i][j].getMarkType() != markType) {
				match = false;
				break;
			}
		}
		return match;
	}
	
	public boolean checkRightDiagonalWinner(int row, int column, MarkType markType) 	// right_top to bottom_left checking
	{	
		boolean match = true;
		
		for(int i=0, j=gameBoard.getSize()-1; i<gameBoard.getSize(); i++, j--) {
			if(gameBoard.getBoard()[i][j] == null || gameBoard.getBoard()[i][j].getMarkType() != markType) {
				match = false;
				break;
			}
		}
		return match;
	}

	public void switchPlayer() 
	{
		if (currentPlayer == players[0]) 
			currentPlayer = players[1];
		else
			currentPlayer = players[0];
	}

	// setters and getters
	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}

	public Board getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(Board gameBoard) {
		this.gameBoard = gameBoard;
	}
	
}
