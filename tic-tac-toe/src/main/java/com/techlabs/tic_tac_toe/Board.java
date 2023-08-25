package com.techlabs.tic_tac_toe;

public class Board {

	private int size;
	private Cell board[][];
	
	public Board(int size) {
		this.size = size;
		board = new Cell[size][size];
	}

	public void printBoard() 
	 {
		System.out.println("");
		for (int i=0; i<size; i++)
		{
			for (int j=0; j<size; j++) 
			{
				if (board[i][j] != null) {
					System.out.print("  "+board[i][j].getMarkType() + "  ");
				}
				else {
					System.out.print("     ");
				}
				System.out.print(" | ");
			}
			System.out.println();
		}
		System.out.println("");
	}
	
	public void markCell(int row, int column, Cell playingMarkType) 
	{
		if(row>=size || column >= size)
			throw new InvalidLocationException("!!!Invalid Location");
		
		if(board[row][column] != null) {		
			throw new CellAlreadyMarkedException("!!!Cell Already Marked");
		}
		
		board[row][column] = playingMarkType;
    }


    public boolean isFreeCells() 
    {
        for (int i = 0; i < size; i++) 
        {
            for (int j = 0; j < size; j++) 
            {
                if (board[i][j] == null) {
                	return true;
                }
            }
        }

        return false;
    }

    // Getters and Setters
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Cell[][] getBoard() {
		return board;
	}

	public void setBoard(Cell[][] board) {
		this.board = board;
	}

}
