package main;

import java.util.ArrayList;
import java.util.Scanner;
//Written by CD + SP
import data.LoadData;
import film.Film;
import menus.MainMenu;
import people.Person;

public class Start
{
	// Scanner for input
	public static Scanner scan = new Scanner(System.in);
	// Scanner for the files
	public static Scanner read = new Scanner(System.in);
	
	// Declare global ArrayList for objects to be stored in and used throughout program
	public static ArrayList<Film> filmList = new ArrayList<Film>(); ;
	public static ArrayList<Person> staffList = new ArrayList<Person>();
	
	public static void main(String[] args) throws Exception 
	{
		// Call the file reading methods and pass the filenames
		LoadData.loadFilms("LargeSampleDataset-FilmTitle.csv");
		System.out.println(filmList.size() + " film records loaded.");
		
		LoadData.loadPeople("LargeSampleDataset-Person.csv");
		System.out.println(staffList.size() + " staff records loaded.");
		
		// Load the main menu
		MainMenu.mainMenu();
		
		// Close scanners
		scan.close();
		read.close();
	}
	
	public static Integer numberValidation()
    {
       int number = 0;
       while (!scan.hasNextInt())
       {
    	   // Continue to loop until the user enters an integer
    	   System.out.println("[ERROR] Invalid input please enter a number.");
    	   scan.next();
       }
       number = scan.nextInt();
       // Return the integer
       return number;
    }
 	
 	public static double doubleValidation()
    {
       double input = 0.0;
       while (!scan.hasNextDouble())
       {
    	   // Continue to loop until the user enters a double
    	   System.out.println("[ERROR] Invalid input please enter a double (0.00).");
    	   scan.next();
       }
       input = scan.nextDouble();
       // Return the double
       return input;
    }
}