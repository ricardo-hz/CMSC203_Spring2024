/*
 * Class: CMSC203 CRN 30339
 * Instructor: Grigoriy Grinberg
 * Description: This class is used to represent a Property object. It implements a 
 * Plot object and contains information about the property.
 * Due: 04/01/2024
 * Platform/compiler: Windows 10 Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ricardo Hernandez
*/
public class Property {
	private String name;
	private String city;
	private double rentalAmt;
	private String owner;
	private Plot plot;
	
	//Constructors
	
	/**
	 * Creates a new Property using empty strings. It also creates a default Plot.
	 */
	public Property() {
		name = "";
		city = "";
		rentalAmt = 0.0;
		owner = "";
		plot = new Plot();
	}
	
	/**
	 * Creates a new Property object using given values. It also creates a default Plot.
	 * @param propertyName property name
	 * @param city city where the property is located
	 * @param rentAmount rent amount
	 * @param owner the owner's name
	 */
	public Property(String propertyName, String city, double rentAmount, String owner) {
		name = propertyName;
		this.city = city;
		rentalAmt = rentAmount;
		this.owner = owner;
		plot = new Plot();
	}
	
	/**
	 * Creates a new Property object using given values. It also creates a Plot using given values
	 * of a plot.
	 * @param propertyName property name
	 * @param city city where the property is located
	 * @param rentAmount rent amount
	 * @param owner the owner's name
	 * @param x the x coordinate of the plot
	 * @param y the y coordinate of the plot
	 * @param width the width coordinate of the plot
	 * @param depth the depth coordinate of the plot
	 */
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		name = propertyName;
		this.city = city;
		rentalAmt = rentAmount;
		this.owner = owner;
		plot = new Plot(x,y,width,depth);
	}
	
	/**
	 * Creates a new copy of the given property object.
	 * @param otherProperty  the Property object to make a copy of
	 */
	public Property(Property otherProperty) {
		this(otherProperty.getPropertyName(), otherProperty.getCity(), otherProperty.getRentAmount(), otherProperty.getOwner(),
				otherProperty.getPlot().getX(), otherProperty.getPlot().getY(), otherProperty.getPlot().getWidth(), otherProperty.getPlot().getDepth());
	}
	//Getters
	
	/**
	 * Gets the city
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Gets the owner
	 * @return the name of the owner
	 */
	public String getOwner() {
		return owner;
	}
	
	/**
	 * Gets the plot
	 * @return the plot
	 */
	public Plot getPlot() {
		return plot;
	}
	
	/**
	 * Gets the property name
	 * @return the property name
	 */
	public String getPropertyName() {
		return name;
	}
	
	/**
	 * Gets the rental amount
	 * @return the rental amount
	 */
	public double getRentAmount() {
		return rentalAmt;
	}
	//Setters
	
	/**
	 * Sets the city
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * Sets the name of the owner
	 * @param owner the name of the new owner
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	/**
	 * Sets the name of the property
	 * @param the new name of the property
	 */
	public void setPropertyName(String name) {
		this.name = name;
	}
	
	/**
	 * Sets the rental amount
	 * @param rentalAmt the new rental amount
	 */
	public void setRentAmount(double rentalAmt) {
		this.rentalAmt = rentalAmt;
	}
	
	/**
	 * Returns a string representing a property object
	 * @return a Property object in the following String format: propertyName, city, owner, rentAmt
	 */
	public String toString() {
		return (name + "," + city + "," + owner + "," + rentalAmt);
	}
}