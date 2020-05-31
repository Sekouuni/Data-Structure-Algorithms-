package functions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import main.Start;

public class spacetime 
{
	public static FileWriter fw = null;
	public static BufferedWriter bw = null;
	public static PrintWriter write = null;
	
	public static void main(String[] args) throws IOException 
	{
		data.LoadData.loadFilms("LargeSampleDataset-FilmTitle.csv");
		System.out.println(Start.filmList.size() + " film records loaded.");
		data.LoadData.loadPeople("LargeSampleDataset-Person.csv");
		System.out.println(Start.staffList.size() + " staff records loaded.");
		
		Runtime r = Runtime.getRuntime();
		long mem1;
		long mem2;
		/*
		 * CHANGE THESE DEPENDING ON METHOD BEING TESTED AND INPUTS USED
		 */
		String methodID = "A";
		String inputsList = "-NO INPUTS USED-";
		/*
		 * CHANGE THESE DEPENDING ON METHOD BEING TESTED AND INPUTS USED
		 */
		long start = 0;
		
		for (int i = 0; i < 10; i++)
		{
			if (i < 10)
			{
				r.gc();
				mem1 = r.freeMemory();
				System.out.println(mem1);
				start = System.nanoTime();
				/*
				 * CHANGE THIS DEPENDING ON METHOD BEING TESTED
				 */
//				menus.RegionMenu.listAllRegions(); // #A
//				menus.RegionMenu.searchByRegion(); // #B
//				menus.TitleMenu.searchForFilm(); // #C
//				menus.PeopleMenu.searchByStaff(); // #Da
//				menus.TitleMenu.searchByFilm(); // #Db
//				menus.PeopleMenu.listHighestCredited(); // #E
//				menus.CategoryMenu.searchHighestByCategory(); // #F
				/*
				 * CHANGE THIS DEPENDING ON METHOD BEING TESTED
				 */
				long end = System.nanoTime();
				long timeTaken = end - start;
				mem2 = r.freeMemory();
				float memInMb = (mem1-mem2) / (1024*1024);
				writeData(mem1, mem2, memInMb, timeTaken, methodID, inputsList);
			}
		}
		write.close();
	}	
	
	public static void writeData(long mem1, long mem2, float memInMb, long timeTaken, String methodID, String inputsList) throws IOException
	{
		fw = new FileWriter("TestingLogs.txt", true);
		bw = new BufferedWriter(fw);
		write = new PrintWriter(bw);
		write.printf("%d 	 %f	%d	%f	%s	%s%n", (mem1 - mem2), memInMb, timeTaken, (Float.valueOf(timeTaken) / (1000*1000*1000)), methodID, inputsList);
		write.flush();
	}
}