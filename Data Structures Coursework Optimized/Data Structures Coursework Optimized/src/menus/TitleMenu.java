package menus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
// Written by CD + SP
import main.Start;
import people.Person;

public class TitleMenu 
{
	/**
	 * Sub menu related to searching data by or for title
	 */
	public static void searchTitle()
	{
		String choice = "";
		
		do
		{		
			System.out.println("-- TITLE MENU --");
			System.out.println("-- Select a Search Option --");
			System.out.println("1 - Search For A Film");
			System.out.println("2 - Search For Staff Of A Given Film");
			System.out.println("Q - Quit");
			System.out.print("Pick : ");
			
			choice = Start.scan.nextLine().trim().toUpperCase();
			
			if (choice.equals("1")) 
			{
				// Asks the user to input a film name and then display all possible film titles along with their region
				System.out.println("--Search For A Film--");
				searchForFilm();
			}
			else if (choice.equals("2"))
			{
				// Asks the user to input a film name and display the staff assigned to film
				System.out.println("--Search For Staff Of A Given Film--");
				searchByFilm();
			}
			else if (choice.equalsIgnoreCase("Q"))
			{
				// Return to main menu
			}
			else
			{
				System.out.println("Invalid Input. Enter one of the options listed.");
			}
				
         } while (!choice.equalsIgnoreCase("Q"));

	}
	
	/**
	 * Display all the possible films matching to a given partial film title
	 */
	public static void searchForFilm() // #C
	{
		System.out.println("Please Specify A Film Name: ");
		String film = Start.scan.nextLine();

		int matches = 0;
		
		for (int i = 0; i < Start.filmList.size(); i++)
		{
			// If current title contains the string from user input output film name and region
			if ((Start.filmList.get(i).getTitle().toLowerCase().contains(film.toLowerCase())))
			{
				System.out.println("Film Title: " +Start.filmList.get(i).getTitle()+ " Region: " +Start.filmList.get(i).getRegion());
				Start.filmList.get(i).getTitle();
				Start.filmList.get(i).getRegion();
				matches++;	
			}
		}
		if (matches > 0)
		{
			// Match at least 1
		}
		else 
		{
			System.out.println("No Possible Matches Found For : " + film);
		}
	}
	
	/**
	 * Display all the staff members who have worked on a specified film
	 */
	public static void searchByFilm() // # Db
	{
		System.out.println("Please Specify A Film Name: ");
		String film = Start.scan.nextLine();
		
		HashMap<String, HashMap<String, ArrayList<Person>>>  titleMap = new HashMap<String, HashMap<String, ArrayList<Person>>>();
		HashMap<String, ArrayList<Person>> staffIdMap = new HashMap<String, ArrayList<Person>>();
		
		for (int i = 0; i < Start.filmList.size(); i++)
		{
			String titleKey = Start.filmList.get(i).getTitle();
			String staffKey = Start.filmList.get(i).getRegion();
			if ((Start.filmList.get(i).getTitle().equalsIgnoreCase(film)))
			{
				String id = Start.filmList.get(i).getTitleID();
				for (int j = 0; j < Start.staffList.size(); j++)
				{
					if (titleMap.containsKey(titleKey) && staffIdMap.containsKey(staffKey) && Start.staffList.get(j).getTitleID().equalsIgnoreCase(id))
					{
						staffIdMap.get(staffKey).add(Start.staffList.get(j));
						titleMap.put(titleKey, staffIdMap);
					}
					else if (Start.staffList.get(j).getTitleID().equalsIgnoreCase(id))
					{
						ArrayList<Person> staff = new ArrayList<Person>();
						staff.add(Start.staffList.get(j));
						staffIdMap.put(staffKey, staff);
						titleMap.put(titleKey, staffIdMap);
					}
				}
			}
		}
		
		if (titleMap.containsKey(film))
		{
			System.out.println("Films Found For The Given Region: " + film);
			System.out.println("More than one film found. Select the version of the film you are looking for by specifiying the region :");
			System.out.println(staffIdMap.keySet());
			String region = Start.scan.nextLine();
			
			for (Entry<String, HashMap<String, ArrayList<Person>>> titleEntry : titleMap.entrySet()) 
			{ 
				for (Entry<String, ArrayList<Person>> staffEntry : titleEntry.getValue().entrySet()) 
			    {
					if(staffEntry.getKey().equalsIgnoreCase(region))
			    	{
			    		for (int i = 0; i < staffEntry.getValue().size(); i++)
			    		{
			    			System.out.println("Staff ID : " + staffEntry.getValue().get(i).getStaffID() + " Category: " + staffEntry.getValue().get(i).getCategory());
			    		}
			    	}
			    }
			}
		}
		else 
		{
			System.out.println("No Films Found For : " + film);
		}
	}
}