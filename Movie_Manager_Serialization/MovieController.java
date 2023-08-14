package com.techlabs.assignments;

import java.util.Scanner;

public class MovieController {

	private MovieManager manager;

	public MovieController(MovieManager manager) {
		super();
		this.manager = manager;
	}
	
	public void start() {
		displayMenu();
	}

	private void displayMenu() {
		
		int choice;
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("\n-------MOVIE MENU-------");
			System.out.println("1. Show All Movies \n2. Add Movie \n3. Show Movie Details \n4. Delete Any Movie \n5. Delete all Movies \n6. Store All Movies In Object File \n7. Exit");
			choice=scanner.nextInt();
			switch(choice) {
				case 1:
					manager.displayMovieList();
					break;
				case 2: 
					Movie movie = setMovieDetails(scanner);
					manager.addMovie(movie);
					break;
				case 3:
					System.out.print("Enter id to search movie: ");
					choice=scanner.nextInt();
					manager.getMovieDetails(choice);;	
					break;
				case 4:
					System.out.print("Enter id to delete movie: ");
					choice=scanner.nextInt();
					manager.deleteMovie(choice);		
					break;
				case 5:
					manager.deleteAllMovies();
					break;
				case 6:
					manager.storeinFile();
					return;
				case 7:
					System.out.println("Thankyou for visiting, come again.");
					return;
				default:
					System.out.println("Wrong choice!!!");
			}
		}
	}
	
	public Movie setMovieDetails(Scanner scanner) {
		
		System.out.println("Enter Movie details: id, name, year, genre");
		int id = scanner.nextInt();
		String name = scanner.next();
		int year = scanner.nextInt();
		String genre = scanner.next();
		Movie movie = new Movie(id, name, year, genre);
		System.out.println("Movie added successfully");
		
		return movie;
		
	}
	
}
