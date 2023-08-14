package com.techlabs.assignments;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieManager {

	private List<Movie> movies;
	private static final String filePath="E:\\Monocept\\movies.txt";		// movies file
	private static final String newFilePath="E:\\Monocept\\updated_movies.txt";		// movies object file 
	
	Scanner scanner = new Scanner(System.in);
	
	public MovieManager() {
		movies = new ArrayList<>();
		
		try {
			loadMovie();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addMovie(Movie movie) {
		movies.add(movie);
	}
	
	public void deleteMovie(int index) {		// clearMovie
		for(Movie movie: movies) {
			if(movie.getId() == index)
			{
				System.out.println("Movie Deleted: "+movie.getName());
				movies.remove(movie);
				return;
			}
		}
	}
	
	public void getMovieDetails(int index) {
		for(Movie movie: movies) {
			if(movie.getId() == index)
			{
				System.out.println("Name: "+movie.getName());
				System.out.println("Year: "+movie.getYear());
				System.out.println("Genre: "+movie.getGenre());
				return;
			}
		}
		System.out.println("Id not found!!!");
	}
	
	public void loadMovie() throws IOException 
	{
		BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
		String currLine = bufferedReader.readLine();
		Movie movieinfo;
		
		while(currLine != null)
		{			
			String word[] = currLine.split(",");
			
			int id = Integer.parseInt(word[0]);
			String name = word[1];
			int year = Integer.parseInt(word[2]);
			String genre = word[3];
			movieinfo = new Movie(id, name, year, genre);
			addMovie(movieinfo);
				
			currLine = bufferedReader.readLine();
		}
		bufferedReader.close();	
	}
	
	public void displayMovieList() {
		
		System.out.println("-------------Movie List-------------");
		for(Movie movie:movies) {
			System.out.println(movie);
		}
	}
	
	public void deleteAllMovies() {
		
		System.out.print("Do you want to delete all movies? ");
		String choice = scanner.next();
		if(choice.equalsIgnoreCase("yes"))
		{
			movies.clear();
			System.out.println("All movies deleted successfully.");
		}
		
	}

	public void storeinFile() 			// serialization
	{		
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(newFilePath);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			
			objectOutputStream.writeObject(movies);
			System.out.println("Object saved in file.");	
			fileOutputStream.close();
			objectOutputStream.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(Exception e)	{
			e.printStackTrace();
		}
		finally {
//			fileOutputStream.close();				// it shows error
//			objectOutputStream.close();
		} 
		readObjectFile();
		
	}
	
	public void readObjectFile() 		// Deserialization
	{		
		try {
			FileInputStream fileInputStream = new FileInputStream(newFilePath);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			
			List<Movie> movieList = (List<Movie>)objectInputStream.readObject();
			
			System.out.println("-------------Updated Movie List-------------");
			for(Movie movie:movieList) {
				System.out.println(movie);
			}
			fileInputStream.close();
			objectInputStream.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(Exception e)	{
			e.printStackTrace();
		}
	}
}
