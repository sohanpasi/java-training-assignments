package com.techlabs.introduction.assignments;

import java.util.Scanner;

public class CalculateWaterBill {

	public static void main(String[] args) {
		
		final int meter_charge = 75;
		int charges, total_water_charges;
		
//		Read input from user
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter number of unit consumed: ");
//		int unitsconsumed = scanner.nextInt();

//		Read input from command line
		int unitsconsumed = Integer.parseInt(args[0]);
		
		System.out.println("Units consumed: "+unitsconsumed);
		
		if(unitsconsumed <= 100)
		{
			charges = unitsconsumed*5;
		}
		else if(unitsconsumed <= 250) 
		{
			charges = unitsconsumed*10;
		}
		else
		{
			charges = unitsconsumed*20;
		}
		
		total_water_charges = charges+meter_charge; 
		System.out.println("Total Water Bill: "+total_water_charges);
		
	}

}
