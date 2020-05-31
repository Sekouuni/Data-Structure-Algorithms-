package menus;

import java.util.ArrayList;
import java.util.HashMap;
// Written by CD + SP
import main.Start;

public class PeopleMenu
{
	/**
	 * Sub menu related to searching data by or for people
	 */
	public static void searchPeople()
	{
		String choice = "";
		
		do
		{		
			System.out.println("-- STAFF MENU --");
			System.out.println("-- Select a Search Option --");
			System.out.println("1 - Search For Films A Staff Member Has Worked On");
			System.out.println("2 - Display Highest Credited Person");
			System.out.println("Q - Quit");
			System.out.print("Pick : ");
			
			choice = Start.scan.nextLine().toUpperCase();
			
			if (choice.equals("1")) 
			{
				// Ask user for input and display the name of the film and their contribution
				System.out.println("--Search For Films A Staff Member Has Worked On--");
				searchByStaff();
			}
			
			else if (choice.equals("2"))
			{
				// Display the highest credited staff member 
				System.out.println("--Display Staff Member With The Highest Amount Of Credits--");
				listHighestCredited();
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
	 * Displays the film titles for all the films that a specified staff member has worked on	
	 */
	public static void searchByStaff() //#Da
	{
		System.out.println("Please Specify A Staff ID: ");
		String staffID = Start.scan.nextLine();
		int matches = 0;

		for (int i = 0; i < Start.staffList.size(); i++)
		{
			// If current staff id matches the user input start searching for matching films
			if ((Start.staffList.get(i).getStaffID().equalsIgnoreCase(staffID)))
			{
				for (int j = 0; j < Start.filmList.size(); j++)
				{
					// If the title ids from the two files match then that staff member has worked on that film
					if (Start.filmList.get(j).getTitleID().equalsIgnoreCase(Start.staffList.get(i).getTitleID()))
					{
						// Output film title and the staff member's category of contribution
						Start.filmList.get(j).printTitle();
						Start.staffList.get(i).printCategory();
						matches++;
					}
				}
			}
		}
		if (matches > 0)
		{
			// Match at least 1
		}
		else 
		{
			System.out.println("No Films Found For The Given Staff Member: " + staffID);
		}
	}
	
	/**
	 * Display highest credited staff member and their films
	 */
	public static void listHighestCredited() // #E
	{
		HashMap<String, ArrayList<String>> staffCreditMap = new HashMap<String, ArrayList<String>>(); 
		String highestKey = "";
		int highest = 0;
	
		// Add every person to the map as a key
		for (int i = 0; i < Start.staffList.size(); i++)
		{
			// Set the key as the current staff id
			String key = Start.staffList.get(i).getStaffID();
			
			// Check if the key already exists. If it does add new values to the key
			if (staffCreditMap.containsKey(key))
			{
				staffCreditMap.get(key).add(Start.staffList.get(i).getTitleID());
			}
			// If it doesn't exist yet set up the key and the initial value
			else
			{
				ArrayList<String> titleID = new ArrayList<String>();
				titleID.add(Start.staffList.get(i).getTitleID());
				staffCreditMap.put(key, titleID);
			}
			if(staffCreditMap.get(key).size() > highest)
	    	{
				highest = staffCreditMap.get(key).size();
				highestKey = key;
	    	}
		}
		
		for (int j = 0; j < Start.filmList.size(); j++)
		{
			// For each item in the array list for the member noted as highest credited
			// Match all the film ids logged to the film names in the filmList
			for (int i = 0; i < staffCreditMap.get(highestKey).size(); i++)
			{
				if (Start.filmList.get(j).getTitleID().equalsIgnoreCase(staffCreditMap.get(highestKey).get(i)))
				{
					System.out.println("Film Title : " + Start.filmList.get(j).getTitle());
				}
			}
		}
	}
}