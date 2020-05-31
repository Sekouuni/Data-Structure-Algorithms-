package data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
// Written by CD + SP
import film.Film;
import main.Start;
import people.Person;

public final class LoadData 
{
	/**
	 * Method to load data from a file containing film data and create a set of film objects
	 * @param fileName A string containing the name of the file to be read
	 * @throws FileNotFoundException If file doesn't exist
	 */
	public static void loadFilms(String fileName) throws FileNotFoundException
	{
		Start.read = new Scanner(new FileReader(fileName));
		
		int i = 0;
		String filmData;
		
		while (Start.read.hasNextLine())
		{
			// Read next line from file
			filmData = Start.read.nextLine();
			if (i == 0)
			{
				// Discard the header (first line)
				// Increment counter
				i++;
			}
			else
			{
				try
				{
					// Create a string list to store the values after they have been checked for formatting
					ArrayList<String> s = new ArrayList<String>();
					// Pass the current line to the split function and return a list of the separated values
//					s = CSVSplit.splitFile(filmData);
					s = CSVSplit.GenericLineSplit(filmData, ',', 8);
					
					Film film;
					if (s.get(7).equalsIgnoreCase("\\N"))
					{
						// Create new film object
						film = new Film(s.get(0), Integer.valueOf(s.get(1)), s.get(2), s.get(3), s.get(4), s.get(5), s.get(6), null);
					}
					else
					{
						// Create new film object
						film = new Film(s.get(0), Integer.valueOf(s.get(1)), s.get(2), s.get(3), s.get(4), s.get(5), s.get(6), Integer.valueOf(s.get(7)));
					}
					// Add object to array list
					Start.filmList.add(film);
					// Increment counter
					i++;
				}
				catch (NumberFormatException e)
				{
					System.out.println(e);
					System.out.println("Line " + (i) + " does not follow the format.");
					break;
				}
			}
		}
	}

	/**
	 * Method to load data from a file containing film data and create a set of film objects
	 * @param fileName A string containing the name of the file to be read
	 * @throws FileNotFoundException If file doesn't exist
	 */
	public static void loadPeople(String fileName) throws FileNotFoundException
	{
		Start.read = new Scanner(new FileReader(fileName));
		
		int i = 0;
		String staffData;
		
		while (Start.read.hasNextLine())
		{
			// Read next line from file
			staffData = Start.read.nextLine();
			if (i == 0)
			{
				// Discard the header (first line)
				// Increment counter
				i++;
			}
			else
			{
				try
				{
					// Create a string list to store the values after they have been checked for formatting
					ArrayList<String> s = new ArrayList<String>();
					// Pass the current line to the split function and return a list of the separated values
//					s = CSVSplit.splitFile(staffData);
					s = CSVSplit.GenericLineSplit(staffData, ',', 6);
					// Create new film object
					Person person = new Person(s.get(0), Integer.valueOf(s.get(1)), s.get(2), s.get(3), s.get(4), s.get(5));
					// Add object to array list
					Start.staffList.add(person);
					// Increment counter
					i++;
				}
				catch (Exception e)
				{
					System.out.println(e);
					System.out.println("Line " + (i) + " does not follow the format.");
					break;
				}
			}
		}
	}
}