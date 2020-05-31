package film;

public class Film 
{
	private String titleID = "";
	private int ordering = 0;
	private String title = "";
	private String region = "";
	private String language = "";
	private String types = "";
	private String attributes = "";
	private Integer isOriginalTitle = null;

	/**
	 * Film class constructor
	 * @param titleID The film unique identifier
	 * @param ordering The film ordering number
	 * @param title The film title
	 * @param region The region the film is shown in
	 * @param language The language the film is shown in
	 * @param types One or more associated attributes
	 * @param attributes Additional descriptions of the film
	 * @param isOriginalTitle Is the film the original (0 - NO or 1 - YES)
	 */
	public Film(String titleID, int ordering, String title, String region, String language, String types, String attributes, Integer isOriginalTitle)
	{
		this.setTitleID(titleID);
		this.setOrdering(ordering);
		this.setTitle(title);
		this.setRegion(region);
		this.setLanguage(language);
		this.setTypes(types);
		this.setAttributes(attributes);
		this.setIsOriginalTitle(isOriginalTitle);
	}
	
	/**
	 * Print the title to console
	 */
	// TODO - Remove this
	public void printTitle()
	{
		System.out.print("Film Title : " + title +".");
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
	 * @return the title
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	/**
	 * @return the region
	 */
	public String getRegion()
	{
		return region;
	}
	
	/**
	 * @param region the region to set
	 */
	public void setRegion(String region)
	{
		this.region = region;
	}
	
	/**
	 * @return the language
	 */
	public String getLanguage()
	{
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language)
	{
		this.language = language;
	}

	/**
	 * @return the types
	 */
	public String getTypes()
	{
		return types;
	}

	/**
	 * @param types the types to set
	 */
	public void setTypes(String types) 
	{
		this.types = types;
	}

	/**
	 * @return the attributes
	 */
	public String getAttributes() 
	{
		return attributes;
	}

	/**
	 * @param attributes the attributes to set
	 */
	public void setAttributes(String attributes) 
	{
		this.attributes = attributes;
	}

	/**
	 * @return the isOriginalTitle
	 */
	public Integer getIsOriginalTitle() 
	{
		return isOriginalTitle;
	}

	/**
	 * @param isOriginalTitle the isOriginalTitle to set
	 */
	public void setIsOriginalTitle(Integer isOriginalTitle) 
	{
		this.isOriginalTitle = isOriginalTitle;
	}
}