package menus;

import java.util.ArrayList;
import java.util.HashMap;
//Written by CD + SP
import main.Start;

public class RegionMenu 
{
	/**
	 * Sub menu related to searching data by or for region
	 */
	public static void searchRegion()
	{
		String choice = "";
		
		do
		{		
			System.out.println("-- REGION MENU --");
			System.out.println("-- Select a Search Option --");
			System.out.println("1 - List All Regions With Films");
			System.out.println("2 - Search For Films By Region");
			System.out.println("Q - Quit");
			System.out.print("Pick : ");
			
			choice = Start.scan.nextLine().toUpperCase();
			
			if (choice.equals("1"))
			{
				// List all regions with registered films
				System.out.println("--List All Regions With Films--");
				listAllRegions();
			}
			
			else if (choice.equals("2"))
			{
				// Allow the user to search by region
				System.out.println("--Search For Film Names By Specified Region--");
				searchByRegion();
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
	 * Method to read through film list and pulling out all regions and then displaying them. No repeating regions!
	 */
	public static void listAllRegions() // #A
	{
		ArrayList<String> regions = new ArrayList<String>();
		System.out.println("The Following Regions Have Films:");
		int j = 0;
		
		for (int i = 0; i < Start.filmList.size(); i++)
		{
			// Check if the film's region isn't empty(\N)
			if (!(Start.filmList.get(i).getRegion()).equalsIgnoreCase("\\N"))
			{
				// 
				if (regions.contains(Start.filmList.get(i).getRegion()))
				{
					// Don't log
				}
				else
				{
					// Increment j and log region
					regions.add(Start.filmList.get(i).getRegion());
					System.out.println(regions.get(j));
					j++;
				}
			}
		}
	}
	
	/**
	 * Display all the film names for a region specified by the user
	 */
	public static void searchByRegion() // #B
	{
		/*
		 *  HashMap with String as key and ArrayList of strings as the values
		 *  Key -> Region
		 *  Value -> List of films for the associated region
		 */
		HashMap<String, ArrayList<String>>  regionMap = new HashMap<String, ArrayList<String>>();
		
		for (int i = 0; i < Start.filmList.size(); i++)
		{
			// Set the key as the current region
			String key = Start.filmList.get(i).getRegion();
			
			// Check if the key already exists. If it does add new values to the key
			if (regionMap.containsKey(key))
			{
				regionMap.get(key).add(Start.filmList.get(i).getTitle());
			}
			// If it doesn't exist yet set up the key and the initial value
			else
			{
				ArrayList<String> title = new ArrayList<String>();
				title.add(Start.filmList.get(i).getTitle());
				regionMap.put(key, title);
			}
		}
		
		// Display possible regions and ask for input
		System.out.println("Please Specify A Region From The Following :");
		System.out.println(regionMap.keySet());
		String region = Start.scan.nextLine();

		// Check if the user input exists in the key set
		if (regionMap.containsKey(region))
		{
			// Match at least 1
			System.out.println("Films Found For The Given Region: " +region);
			// For each value for the given key output to console
			for (String s : regionMap.get(region))
			{
				System.out.println(s);
			}
		}
		// TODO - Change this / different checks to separate invalid input and no matches
		else 
		{
			System.out.println("No Films Found For The Given Region: " +region);
		}
	}
}