package menus;

import main.Start;

public class MainMenu 
{
	/**
	 * Master menu that sends the user to the appropriate sub menus depending on their input
	 * @throws Exception
	 */
	public static void mainMenu() throws Exception
	{
		String choice = "";
		
		// Start a repeating main menu that loops until the Quit option is chosen.
		do
		{		
			System.out.println("-- MAIN MENU NEW --");
			System.out.println("-- Select a Search Option --");
			System.out.println("1 - Region");
			System.out.println("2 - Title");
			System.out.println("3 - People");
			System.out.println("4 - Category");
			System.out.println("Q - Quit");
			System.out.print("Pick : ");
			
			choice = Start.scan.nextLine().toUpperCase();
			
			switch (choice) 
			{
				case "1" : 
				{
					// Load region search
					RegionMenu.searchRegion();
					choice = "";
					break;
				}
				case "2" : 
				{
					// Load title search
					TitleMenu.searchTitle();
					choice = "";
					break;
				}
				case "3" : 
				{
					// Load people search
					PeopleMenu.searchPeople();
					choice = "";
					break;
				} 
				case "4" : 
				{
					// Load category search
					CategoryMenu.searchCategory();
					choice = "";
					break;
				}   
				case "Q" :
				{
					// Exit switch statement and then the loop
					break;
				}
				default :
				{
					// If the input is not one of the 4 options an error is shown and the user will be asked again
					System.out.println("[ERROR] invalid input");
				}
			}
         } while (!choice.equalsIgnoreCase("Q"));

		System.out.println("Goodbye!");
	}
}