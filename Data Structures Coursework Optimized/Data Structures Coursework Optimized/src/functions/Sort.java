package functions;

import java.util.List;
// Written by CD + SP
import film.Film;
import people.Person;

public class Sort 
{
	/**
	 * Enumeration that lists the possible attributes to sort a list by
	 */
	public enum Attribute
	{
		CATEGORY, TITLEID, STAFFID, ORDERING
	}
	
	/**
	 * Performs an insert sort on a list of person objects
	 * @param list The list to be sorted
	 * @param atb The attribute to sort the list by
	 * @return The sorted list
	 */
	public static List<Person> insertSortPerson(List<Person> list, Attribute atb)
	{
		Person temp;
		for (int i = 1; i < list.size(); i++)
		{
			for (int j = i; j > 0; j--)
			{
				if (atb == Attribute.CATEGORY)
				{
					if (list.get(j).getCategory().compareTo(list.get(j-1).getCategory()) < 0)
					{
						temp = list.get(j-1);
						list.set(j - 1,  list.get(j));
						list.set(j,  temp);
					}
				}
				else if (atb == Attribute.STAFFID)
				{
					if (list.get(j).getStaffID().compareTo(list.get(j-1).getStaffID()) < 0)
					{
						temp = list.get(j-1);
						list.set(j - 1,  list.get(j));
						list.set(j,  temp);
					}
				}
				
				else if (atb == Attribute.ORDERING)
				{
					if (list.get(j).getOrdering() < (list.get(j-1).getOrdering()))
					{
						temp = list.get(j-1);
						list.set(j - 1,  list.get(j));
						list.set(j,  temp);
					}
				}
			}
		}
		return list;
	}
	
	/**
	 * Performs an insert sort on a list of film objects
	 * @param list The list to be sorted
	 * @param atb The attribute to sort the list by
	 * @return The sorted list
	 */
	public static List<Film> insertSortFilm(List<Film> list, Attribute atb)
	{
		Film temp;
		for (int i = 1; i < list.size(); i++)
		{
			for (int j = i; j > 0; j--)
			{
				if (atb == Attribute.TITLEID)
				{
					if (list.get(j).getTitleID().compareTo(list.get(j-1).getTitleID()) < 0)
					{
						temp = list.get(j-1);
						list.set(j - 1,  list.get(j));
						list.set(j,  temp);
					}
				}
				else if (atb == Attribute.ORDERING)
				{
					if (list.get(j).getOrdering() < (list.get(j-1).getOrdering()))
					{
						temp = list.get(j-1);
						list.set(j - 1,  list.get(j));
						list.set(j,  temp);
					}
				}
			}
		}
		return list;
	}
}