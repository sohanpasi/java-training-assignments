package com.techlabs.introduction.assignments;

import java.util.Scanner;

public class TreasureIsland {

	public static void main(String[] args) {

		System.out.println("\t Welcome to Treasure Island \n Your mission is to find the treasure.\n");

//		Read input from command line
/*		String step1 = args[0];
		step1 = step1.toLowerCase();
		if(step1.equals("left"))
		{
			String step2 = args[1];
			step2 = step2.toLowerCase();
			if(step2.equals("wait"))
			{
				String step3= args[2];
				step3 = step3.toLowerCase();
				if(step3.equals("red"))
					System.out.println("\t Burned by fire.\n Game Over.");
				else if(step3.equals("blue"))
					System.out.println("\t Eaten by beasts.\n Game Over.");
				else if(step3.equals("yellow"))
					System.out.println("\t You Win!");	
				else
					System.out.println("\t Game Over.");
			}
			else
				System.out.println("\t Attacked by trout.\n Game Over.");
		}
		else
			System.out.println("\t Fall into a hole.\n Game Over.");	
*/		
		
//		Read input from user
		Scanner scanner = new Scanner(System.in);
		System.out.println("left or right?");
		String step1 = scanner.nextLine();
		step1 = step1.toLowerCase();
		if(step1.equals("left"))
		{
			System.out.println("swim or wait?");
			String step2 = scanner.nextLine();
			step2 = step2.toLowerCase();
			if(step2.equals("wait"))
			{
				System.out.println("which door (Red/ Yellow/ Blue)?");
				String step3 = scanner.nextLine();
				step3 = step3.toLowerCase();
				if(step3.equals("red"))
					System.out.println("\n Burned by fire.\n Game Over.");
				else if(step3.equals("blue"))
					System.out.println("\n Eaten by beasts.\n Game Over.");
				else if(step3.equals("yellow"))
					System.out.println("\n You Win!");	
				else
					System.out.println("\n Game Over.");
			}
			else
				System.out.println("\n Attacked by trout.\n Game Over.");
		}
		else
			System.out.println("Fall into a hole.\n Game Over.");
		
		scanner.close();
	}

}
