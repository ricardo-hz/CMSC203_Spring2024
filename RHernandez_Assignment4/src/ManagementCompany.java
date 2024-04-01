/*
 * Class: CMSC203 CRN 30339
 * Instructor: Grigoriy Grinberg
 * Description: This class represents a management company and the different actions
 * a management company can take. It provides methods to assist in managing properties of
 * and getting information about those properties.
 * Due: 04/01/2024
 * Platform/compiler: Windows 10 Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ricardo Hernandez
*/
public class ManagementCompany {
	//Instance variables
	static final int MAX_PROPERTY = 5;
	static final int MAX_WIDTH = 10;
	static final int MAX_DEPTH = 10;
	private String name;
	private String taxID;
	private double mgmFee;
	private Property[] properties;
	private Plot plot;
	private int numberOfProperties;
	private int propertyIndex = 0;
	
	//Constructors
	
	/**
	 * Creates a ManagementCompany object using empty strings, creates a default Plot with 
	 * maximum width and depth and it initializes the properties array.
	 */
	public ManagementCompany() {
		name = "";
		taxID = "";
		mgmFee = 0.0;
		plot = new Plot();
		plot.setWidth(MAX_WIDTH);
		plot.setDepth(MAX_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}
	
	/**
	 * Creates a ManagementCompany object using the given values, creates a default Plot with 
	 * maximum width and depth and it initializes the properties array.
	 * @param name management Company name
	 * @param taxID tax ID
	 * @param mgmFee management fee
	 */
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		plot = new Plot();
		plot.setWidth(MAX_WIDTH);
		plot.setDepth(MAX_DEPTH);
		properties = new Property[MAX_PROPERTY];
		numberOfProperties = 0;
	}
	
	/**
	 * Creates a ManagementCompany object using the given values creates a Plot using the given 
	 * values and it initializes the properties array. This constructor calls an appropriate 
	 * existing constructor. MAY NEED TO REVISIT
	 * @param name management company name
	 * @param taxID tax ID
	 * @param mgmFee the management fee
	 * @param x x coordinate of the plot
	 * @param y y coordinate of the plot
	 * @param width width coordinate of the plot
	 * @param depth depth of the plot
	 */
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this(name,taxID,mgmFee);
		this.plot.setAll(x, y, width, depth);
		numberOfProperties = 0;
	}
	
	/**
	 * Creates a new ManagementCompany copy of the given ManagementCompany. 
	 * This constructor calls an appropriate existing constructor. MAY NEED TO REVISIT
	 * @param otherCompany the company which should be copied
	 */
	public ManagementCompany(ManagementCompany otherCompany) {
		this(otherCompany.name,otherCompany.taxID,otherCompany.mgmFee);
		this.plot.setX(otherCompany.plot.getX());
		this.plot.setY(otherCompany.plot.getY());
		this.plot.setWidth(otherCompany.plot.getWidth());
		this.plot.setDepth(otherCompany.plot.getDepth());
		for(int i = 0; i < properties.length; i++) {
			this.properties[i] = new Property(otherCompany.properties[i]);
		}
		numberOfProperties = otherCompany.numberOfProperties;
	}
	
	/**
	 * Adds a new property to the properties array.
	 * @param name property name
	 * @param city city where the property is located
	 * @param rent rent amount
	 * @param owner the owner's name
	 * @return -1 if the array is full, the index of the array where the property was added otherwise
	 */
	public int addProperty(String name, String city, double rent, String owner) {
		//Check if the array is full
		if(numberOfProperties == MAX_PROPERTY) {
			return -1;
		}
		else {
			properties[propertyIndex] = new Property(name, city, rent, owner);
			propertyIndex++;
			numberOfProperties++;
			return propertyIndex - 1;
		}
	}
	
	/**
	 * Adds a new property to the properties array.
	 * @param name property name
	 * @param city city where the property is located
	 * @param rent rent amount
	 * @param owner the owner's name
	 * @param x the x coordinate of the plot
	 * @param y the y coordinate of the plot
	 * @param width the width coordinate of the plot
	 * @param depth the depth coordinate of the plot
	 * @return -1 if the array is full,
	 * -3 if management company does not encompass the property plot, 
	 * -4 if property plot overlaps ANY of properties in array, otherwise 
	 * returns the index of the array where the property was added.
	 */
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		Plot newPlot = new Plot(x,y,width,depth);
		//Check if properties array is full
		if(numberOfProperties == MAX_PROPERTY) {
			return -1;
		}
		//Check for encompassing
		if(!(plot.encompasses(newPlot))) {
			return -3;
		}
		//Check for overlap
		for(int i = 0; i < properties.length; i++) {
			if(properties[i] != null && properties[i].getPlot().overlaps(newPlot)) {
				return -4;
			}
		}
		
		//Otherwise, add property
		properties[propertyIndex] = new Property(name, city, rent, owner);
		propertyIndex++;
		numberOfProperties++;
		return propertyIndex - 1;
	}
	
	/**
	 * Creates a property object by copying from another property 
	 * and adds it to the properties array.
	 * @param property The property to be copied
	 * @return -1 if the array is full, -2 if the Property object is null, 
	 * -3 if management company does not encompass the property plot, 
	 * -4 if property plot overlaps ANY of properties in array, otherwise 
	 * return the index of the array where the property was added.
	 */
	public int addProperty(Property property) {
		//Check if properties array is full
		if(numberOfProperties == MAX_PROPERTY) {
			return -1;
		}

		//Check for encompassing
		if(!(plot.encompasses(property.getPlot()))) {
			return -3;
		}
		//Check for overlap
		for(int i = 0; i < properties.length; i++) {
			if(properties[i] != null && properties[i].getPlot().overlaps(property.getPlot())) {
				return -4;
			}
		}
		/*
		 * Check for null object. If object isn't null, add property to array and return
		 * index.
		 */
		try {
			properties[propertyIndex] = new Property(property.getPropertyName(), property.getCity(), 
					property.getRentAmount(), property.getOwner(), property.getPlot().getX(),
					property.getPlot().getY(),property.getPlot().getWidth(),
					property.getPlot().getDepth());
			propertyIndex++;
			numberOfProperties++;
			return propertyIndex - 1;
		}
		catch(Exception propertyObjectNull) {
			return -2;
		}
	}
	
	/**
	 * Removes(nullifies) the LAST property in the properties array
	 */
	public void removeLastProperty() {
		properties[properties.length - 1] = null;
	}
	
	/**
	 * Checks if the properties array has reached the maximum capacity
	 * @return true if properties array is full, false otherwise
	 */
	public boolean isPropertiesFull() {
		boolean isPropertiesFull = false;
		int count = 0;
		for(int i = 0; i< properties.length; i++) {
			if(properties[i] != null) {
				count++;
			}
		}
		if(count == MAX_PROPERTY) {
			isPropertiesFull = true;
		}
		return isPropertiesFull;
	}
	
	/**
	 * Gets the number of existing properties in the array
	 * @return the number of existing properties in the array
	 */
	public int getPropertiesCount() {
		int count = 0;
		for(int i = 0; i < properties.length; i++) {
			if(properties[i] != null) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Returns the total rent of the properties in the properties array 
	 * @return total rent
	 */
	public double getTotalRent() {
		double totalRent = 0.0;
		for(int i = 0; i < properties.length; i++) {
			if(properties[i] != null) {
				totalRent+=properties[i].getRentAmount();
			}
		}
		return totalRent;
	}
	
	/**
	 * Gets the property in the array with the maximum amount of rent
	 * @return the property in the array which has the highest amount of rent
	 */
	public Property getHighestRentPropperty() {
		Property highestRentProperty = properties[0];
		for(int i = 0; i < properties.length; i++) {
			if(properties[i] != null) {
				if(properties[i].getRentAmount() > highestRentProperty.getRentAmount()){
					highestRentProperty = properties[i];
				}
			}
		}
		return highestRentProperty;
	}
	
	/**
	 * Checks if the management company has a valid (between 0-100) fee
	 * @return true if the management fee is valid (between 0-100), false otherwise
	 */
	public boolean isManagementFeeValid() {
		boolean isMgmtFeeValid = false;
		if(this.mgmFee >= 0 && this.mgmFee <= 100) {
			isMgmtFeeValid = true;
		}
		return isMgmtFeeValid;
	}
	
	/**
	 * Gets the name.
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Gets the tax ID.
	 * @return the tax ID
	 */
	public String getTaxID() {
		return this.taxID;
	}
	
	/**
	 * Gets the properties.
	 * @return the properties
	 */
	public Property[] getProperties() {
		return this.properties;
	}
	
	/**
	 * Gets the management fee per company.
	 * @return the mgmFee per company
	 */
	public double getMgmFeePer() {
		return this.mgmFee;
	}
	
	/**
	 * Gets the plot.
	 * @return the plot
	 */
	public Plot getPlot() {
		return this.plot;
	}
	
	/**
	 * Represents the information of all the properties in the properties array.
	 * @return information of ALL the properties within this management company 
	 * by accessing the properties array. This value should include each management 
	 * company's name, taxID as well each property's name,city,owner,rent Amount
	 */
	public String toString() {
		String str = "";
		str += "List of the properties for " + this.getName() + ", taxID: " + this.getTaxID() + "\n";
		str += "______________________________________________________\n";
		for(int i = 0; i < properties.length; i++) {
			if(properties[i] != null) {
				str += properties[i].toString();
				str += "\n______________________________________________________\n";
			}
		}
		str += "\n total management Fee: " + (getTotalRent() * (mgmFee * .01));
		return str;
	}
}
