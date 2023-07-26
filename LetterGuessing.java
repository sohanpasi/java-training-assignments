package com.techlabs.introduction.assignments;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LetterGuessing {

	public static String generateRandomWord()
	{
	    Random random = new Random();
	    char[] word = new char[random.nextInt(8)+3]; // generate word between 3 to 10 length.
	    for(int j = 0; j < word.length; j++)
	    {
	    	word[j] = (char)('a' + random.nextInt(26));
	    }
	    
	    return String.valueOf(word);
	}
	
	public static void main(String[] args) {
		
		int life = 5;
		int match, match_all;
	
//		String subjects[] = {"computer", "mathematics", "physics", "chemistry", "biology", "zoology", "english", "history", "economics"};
//		Random random = new Random();
//		String word = subjects[random.nextInt(subjects.length)];
		Scanner scanner = new Scanner(System.in);
		
		String word = generateRandomWord();
		System.out.println("Random generated word: "+word);
		char word_arr[] = new char[word.length()];
		char replacement = '_';
		Arrays.fill(word_arr,  replacement);
		
		do {
			match = match_all = 0;
			for(int i=0; i<word_arr.length; i++)
			{
				System.out.print(word_arr[i]+" ");
			}
			System.out.print("\nGuess any letter? ");
			char ch = scanner.next().charAt(0);
			
			for(int i=0; i<word.length(); i++)		// check a letter is present in string or not
			{
				int comp1 = Character.compare(ch, word.charAt(i));
				
				if(comp1==0)
				{
					int comp3 = Character.compare(ch, word_arr[i]);
					if(comp3==0)
						continue;
					else
						word_arr[i]=word.charAt(i);
					match = 1;
					break;
				}	
			}
			
			for(int i=0; i<word.length(); i++)		// all letter are filled
			{
				int comp2 = Character.compare('_', word_arr[i]);
				if(comp2!=0)
				{
					++match_all;
				}
			}
			
			if(match_all==word.length())
			{
				System.out.println("\n-----You Won------");
				break;
			}
			
			if(match==0)
			{
				--life;
				System.out.println("\nLose a life: "+life);
				if(life<1)
				{
					System.out.println("\nGame Over!!!");
					break;
				}
			}
		}while(true);
		
		scanner.close();
		
	}	
}
