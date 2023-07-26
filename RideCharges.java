package com.techlabs.introduction.assignments;

import java.util.Scanner;

public class RideCharges {

	public static void main(String[] args) {
		
		String first_choice, second_choice;
		int ride_charges=0;
		
		System.out.println("Can you ride for height 120cm or high? (Yes/ No)");
		Scanner scanner = new Scanner(System.in);
		first_choice = scanner.next();
		first_choice = first_choice.toLowerCase();
		if(first_choice.equals("no"))
		{
			System.out.println("Can't Ride");
			return;
		}
		else
		{
			System.out.println("You can ride.\nEnter your age: ");
			int age = scanner.nextInt();
			if(age<12)
				ride_charges = 5;
			if(age>=12 && age < 18)
				ride_charges = 7;
			if(age>=18 && age < 45)
				ride_charges = 12;
			if(age>=45 && age < 55)
				ride_charges = 0;
			
			System.out.println("You want photos? (Yes/No)");
			second_choice = scanner.next();
			second_choice = second_choice.toLowerCase();
			if(second_choice.equals("yes"))
				ride_charges = ride_charges+3;
		}
		System.out.println("Total Charges $"+ ride_charges);
		
		scanner.close();
	}

}
