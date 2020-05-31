package data;

import java.util.LinkedList;
import java.util.Queue;
//Written by CD + SP
import java.util.ArrayList;

public class CSVSplit
{
	/**
	 * Method to take comma separated files and convert them to an ArrayList of strings.
	 * @param inputData The comma separated line from a file to be split. 
	 * @return ArrayList of strings of the separated values.
	 */
	public static ArrayList<String> splitFile(String inputData)
	{
		ArrayList<String> s = new ArrayList<String>();
		// Boolean value to keep check if the current character is between commas or not
	    boolean betweenCommas = true;
	    // Start is used to keep track of the start of the string we want to store (just after the comma)
	    int start = 0;
	    /* Loop over every character in the string to check for and commas and ""
	     * ignore any commas between " "  
	     */
	    for(int j = 0; j < inputData.length(); j++)
	    {
	    	// Check if the current character is a comma and is between other commas
	        if(inputData.charAt(j) == ',' && betweenCommas)
	        {
	        	// Add all the characters from the start counter to j to the string list (the values between commas)
	            s.add(inputData.substring(start, j));
	            start = j + 1;                
	        }   
	        else if(inputData.charAt(j) == '"')
	        {
	        	/* End of quotations no longer between commas 
	        	 * -> flip the value (true if false and false if true)
	        	 */
	        	betweenCommas =! betweenCommas;
	        }
	    }
	    // Add the substring to list
	    s.add(inputData.substring(start));
	    // Return the array list
		return s;
	}
	
	/**
	 * A method to separate values from a line into an array list.
	 * @param currentLine The line of a file to be separated
	 * @param separator The character that separates elements in a line
	 * @param columns The number of elements expected to be returned
	 * @return The elements separated into an array list
	 */
	public static ArrayList<String> GenericLineSplit(String currentLine, char separator, int columns)
	{
		// Create a queue of characters using linked list implementation 
		Queue<Character> charQueue = new LinkedList<Character>();
		ArrayList<String> s = new ArrayList<String>();
		
		boolean betweenCommas = true;
		String subString = "";
		int columnNo = 0;
			
		// Loop through the line passed character by character
		for(int i = 0; i < currentLine.length(); i++)
		{
			/* Check if the current character is the separator (defined as an argument) 
			 * and is between commas OR is the last character in the line
			 */ 
			if(currentLine.charAt(i) == separator && betweenCommas) // TODO|| ((i) == currentLine.length()))
			{
				// Empty the contents of the queue into the array list
				do
				{	
					subString += String.valueOf(charQueue.poll());
				} while (!(charQueue.isEmpty()));
				s.add(subString);
				subString = "";
				columnNo++;
			}
			// Else check if the current character is a quotation mark
			else if(currentLine.charAt(i) == '"')
			{
				// Flip the value of between commas (True becomes False. False becomes True.)
				betweenCommas =! betweenCommas; 
			}
			else
			{
				// Else add the current character to the queue.
				charQueue.offer(currentLine.charAt(i));
			}
		}
		
		if (!(charQueue.isEmpty()))
		{
			do
			{	
				subString += String.valueOf(charQueue.poll());
			} while (!(charQueue.isEmpty()));
			s.add(subString);
			columnNo++;
		}	
		
		/* If the number of columns found doesn't match the number expected (specified as an argument)
		 * Print error message
		 */
		if (!(columnNo == columns)) 
			System.out.println("Columns expected did not match actual number of columns found.");
		// Return the array list to the data methods		
		return s;
	}
}