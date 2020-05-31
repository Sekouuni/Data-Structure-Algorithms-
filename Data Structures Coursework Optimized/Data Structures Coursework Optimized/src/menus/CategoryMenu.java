package menus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
// Written by CD + SP
import main.Start;

public class CategoryMenu 
{
	/**
	 * Sub menu related to searching data by or for category
	 */
	public static void searchCategory()
	{
		String choice = "";
		
		do
		{		
			System.out.println("--CATEGORY MENU--");
			System.out.println("1 - Search For Highest Credited Staff Member By Category");
			System.out.println("Q - Quit");
			System.out.print("Pick : ");
			
			choice = Start.scan.nextLine().toUpperCase();
			
			if (choice.equals("1")) 
			{
				//Ask for user input and display highest credited staff member and films they have worked on
				System.out.println("Search For Highest Credited Staff By Category");
				searchHighestByCategory();
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
	 * Displays the film titles for the highest credited person for a specified category
	 */
	public static void searchHighestByCategory() // #F
	{
		int counter = 0;
		int highest = 0;
		String highestKey = "";
		
		System.out.println("Please input a category : "); //Ask user for input
		String input = Start.scan.nextLine();
		System.out.println("Searching...");
	
		HashMap<String, HashMap<String, ArrayList<String>>> categoryMap = new HashMap<String, HashMap<String, ArrayList<String>>>(); //Map of highest in category
		
		for (int i = 0; i <Start.staffList.size(); i++)
		{	
			String staffKey = Start.staffList.get(i).getStaffID();
			String categoryKey = Start.staffList.get(i).getCategory();
			// Does the outer map key exist
			if (categoryMap.containsKey(categoryKey))
			{
				// Does the inner map key exist
				if (categoryMap.get(categoryKey).containsKey(staffKey))
				{
					// Add to the value (ArrayList)
					categoryMap.get(categoryKey).get(staffKey).add(Start.staffList.get(i).getTitleID());
				}
				else
				{
					// Sets up arraylist
					ArrayList<String> titleIDList = new ArrayList<String>();				
					titleIDList.add(Start.staffList.get(i).getTitleID());
					// Sets up inner map? and outer key
					HashMap<String, ArrayList<String>> staffMap = new HashMap<String, ArrayList<String>>();
					staffMap.put(staffKey, titleIDList);
					categoryMap.get(categoryKey).put(staffKey, titleIDList);
				}
			}
			else
			{
				ArrayList<String> titleIDList = new ArrayList<String>();
				titleIDList.add(Start.staffList.get(i).getTitleID());
				// Sets up an inner map, adds key and value to inner map and then adds inner map to outer map for current key
				HashMap<String, ArrayList<String>> staffMap = new HashMap<String, ArrayList<String>>();
				staffMap.put(staffKey, titleIDList);
				categoryMap.put(categoryKey, staffMap);
			}
		}
//		for (String s : categoryMap.keySet())
//		{
//			System.out.println(s);
//			for (String l : categoryMap.get(s).keySet())
//			{
//				System.out.println("    " +l);
//				System.out.println("        "+categoryMap.get(s).get(l).toString());
//			}
//		}

		if (categoryMap.containsKey(input))
		{
			// For each entry in the category map entry set
			for (Entry<String, HashMap<String, ArrayList<String>>> catEntry : categoryMap.entrySet()) 
			{ 
				if (catEntry.getKey().equalsIgnoreCase(input))
				{
					// For each value in the entry set for each staff entry in the current category entry
					for (Entry<String, ArrayList<String>> staffEntry : catEntry.getValue().entrySet()) 
				    {
						if (staffEntry.getValue().size() > highest)
				    	{
				    		highest = staffEntry.getValue().size();
				    		highestKey = staffEntry.getKey();
				    	}
				    }
				}
			}
			
			for (int i = 0; i < Start.filmList.size(); i++)
			{
				for (int j = 0; j < categoryMap.get(input).get(highestKey).size(); j++)
				{
					if (Start.filmList.get(i).getTitleID().equalsIgnoreCase(categoryMap.get(input).get(highestKey).get(j)))
					{
						System.out.println("Film Title: " + Start.filmList.get(i).getTitle());
						counter++;
					}
				}				
			}
		}
		else 
		{
			System.out.println("No Films Found For : " + input);
		}
		System.out.println(counter);
	}
}