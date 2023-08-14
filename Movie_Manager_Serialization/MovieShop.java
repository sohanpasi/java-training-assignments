package com.techlabs.assignments;

public class MovieShop {

	public static void main(String[] args) {
		
		MovieController controller = new MovieController(new MovieManager()); 
		controller.start();
	}

}
