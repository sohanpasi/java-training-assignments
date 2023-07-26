package com.techlabs.introduction.assignments;

import java.util.Scanner;

public class CountCurrency {

	public static void main(String[] args) {
		
	
		int amount, two_thousand, five_hundred, two_hundred, hundred;
		
		System.out.println("Enter any amount: ");
		Scanner scanner = new Scanner(System.in);
		amount = scanner.nextInt();
		if(amount > 50000)
			System.out.println("Amount exceeds withdrawal limit of 50000");
		else if(amount%100 != 0)
			System.out.println("Amount should be in multiples of 100");
		else
		{
			two_thousand = amount/2000;
			amount = amount - two_thousand*2000;
			five_hundred = amount/500;
			amount = amount - five_hundred*500;
			two_hundred = amount/200;
			amount = amount - two_hundred*200;
			hundred = amount/100;
			
			System.out.println("Two Thousand: "+ two_thousand);
			System.out.println("Five Hundred: "+ five_hundred);
			System.out.println("Two Hundred: "+ two_hundred);
			System.out.println("one Hundred: "+ hundred);
		}
		scanner.close();
	}

}
