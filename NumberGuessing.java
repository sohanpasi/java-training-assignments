package com.techlabs.introduction.assignments;

import java.util.Scanner;

public class NumberGuessing {
	

	public static void main(String[] args) {

		int guess=0, random_number, count=1;
		String choice="";
		
		Scanner scanner = new Scanner(System.in);
		
		do
		{
			random_number = (int) (Math.random()*100)+1;
			System.out.println("Random number generated: "+random_number);
			System.out.println("Guess a number? ");
			guess = scanner.nextInt();
			if(guess==random_number)
			{
				System.out.println("You Won: in attempts: "+count);
				System.out.println("Do you want to play the game again: (yes/no)");
				choice = scanner.next();
				choice = choice.toLowerCase();
				if(choice.equals("no"))
				{
					System.out.println("Game over");
					return;
				}
				else
				{
					count=1;
					continue;
				}			
			}
			else if(guess< random_number)
			{
				System.out.println("Sorry, Too low");
			}
			else
			{
				System.out.println("Sorry, Too High");
			}
			count++;
			
			if(count == 10)
				System.out.println("Limit Exceed");
			
		}while(choice.equals("yes") || guess!=random_number) ;
		
		scanner.close();
	}

}
