package com.techlabs.reflection;

import java.util.Random;
import java.util.Scanner;

public class PigDiceRefactoring {
	
	private static int min=1;
	private static int max=6;
	private static int currTurnScore=0;
	private static int prevTurnScore=0;
	private static int turn=1;
	
	public static void print(int currTurnScore, int prevTurnScore)
	{
		int totalScore=(currTurnScore+prevTurnScore);
		System.out.println("Score for turn: "+currTurnScore);
		System.out.println("Total score: "+totalScore);
	}
	
	public static void roll() 
	{
		Random random = new Random(); 
		int die = random.nextInt(max-min+1)+min;
		System.out.println("Die: "+die);
		
		if(die>1)
		{
			currTurnScore = currTurnScore+die;
		}
		if(die==1)
		{
			turn++;
			currTurnScore=0;
			prevTurnScore=0;
			System.out.println("Turn over. No score.\n\nTURN "+turn);
		}
		if((currTurnScore+prevTurnScore)>=20)
		{
			print(currTurnScore, prevTurnScore);
			System.out.println("\n\nYou finished in "+turn+" turns!");
			System.out.println("\n\nGame over");
			System.out.println("\nYou want to play again?(yes/no)");
			Scanner scanner=new Scanner(System.in);
			String choice = scanner.next();
			choice = choice.toLowerCase();
			if(choice.equals("no"))
			{
				System.out.println("*********Thankyou for playing*********");
				System.exit(0);
			}
			
			turn=1;
			currTurnScore=prevTurnScore=die=0;
			System.out.println("Turn 1");
		}
	}
	
	public static void hold() 
	{
		turn++;
		print(currTurnScore, prevTurnScore);
		prevTurnScore = prevTurnScore+currTurnScore;
		currTurnScore=0;
		System.out.println("\nTURN "+turn);
	}
	
	public static void rollDice(Scanner scanner) 
	{
		char ch;
		
		while(true) 
		{
			System.out.print("Roll or hold? (r/h): ");
			ch = scanner.next().charAt(0);
			
			if(ch=='r' || ch =='R')
			{
				roll();
			}
			if(ch=='h' || ch=='H')
			{
				hold();
			}
		}
	}

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("TURN 1");
		rollDice(scanner);
	}
}
