package people;

public class Person
{
	private String titleID = "";
	private int ordering = 0;
	private String staffID = "";
	private String category = "";
	private String job = "";
	private String characters = "";
	
	/**
	 * Person class constructor
	 * @param titleID The film unique identifier
	 * @param ordering The film ordering number
	 * @param staffID The staff unique identifier
	 * @param category The category of job that the staff member worked in
	 * @param job The specific job title
	 * @param characters The name of the character played
	 */
	public Person(String titleID, int ordering, String staffID, String category, String job, String characters)
	{
		this.setTitleID(titleID);
		this.setOrdering(ordering);
		this.setStaffID(staffID);
		this.setCategory(category);
		this.setJob(job);
		this.setCharacters(characters);
	}
	
	/**
	 * Print the category to console
	 */
	// TODO - Remove this
	public void printCategory()
	{
		System.out.print(" Category : " + category + "\n");
	}

	/**
	 * @return the titleID
	 */
	public String getTitleID() 
	{
		return titleID;
	}

	/**
	 * @param titleID the titleID to set
	 */
	public void setTitleID(String titleID) 
	{
		this.titleID = titleID;
	}

	/**
	 * @return the ordering
	 */
	public int getOrdering() 
	{
		return ordering;
	}

	/**
	 * @param ordering the ordering to set
	 */
	public void setOrdering(int ordering) 
	{
		this.ordering = ordering;
	}

	/**
	 * @return the staffID
	 */
	public String getStaffID() 
	{
		return staffID;
	}

	/**
	 * @param staffID the staffID to set
	 */
	public void setStaffID(String staffID) 
	{
		this.staffID = staffID;
	}
	
	/**
	 * @return the category
	 */
	public String getCategory()
	{
		return category;
	}
	
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category)
	{
		this.category = category;
	}

	/**
	 * @return the job
	 */
	public String getJob() 
	{
		return job;
	}

	/**
	 * @param job the job to set
	 */
	public void setJob(String job) 
	{
		this.job = job;
	}

	/**
	 * @return the characters
	 */
	public String getCharacters() 
	{
		return characters;
	}

	/**
	 * @param characters the characters to set
	 */
	public void setCharacters(String characters) 
	{
		this.characters = characters;
	}
}