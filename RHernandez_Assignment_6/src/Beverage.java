/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Represents a beverage object
 * Due: 04/29/2024
 * Platform/compiler: Windows 10 Eclipse IDE
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ricardo Hernandez
*/
public abstract class Beverage{
	private String beverageName;
	private Type beverageType;
	private Size beverageSize;
	//TODO Should the next 2 variables really be private?
	private final double BASE_PRICE = 2.0;
	private final double SIZE_UP_PRICE = 0.50;
	
	/**
	 * Creates a beverage object using given values
	 * @param bevName Beverage name
	 * @param type Beverage type
	 * @param size Beverage size
	 */
	public Beverage(String bevName, Type type, Size size) {
		beverageName = bevName;
		beverageType = type;
		beverageSize = size;
	}
	
	/**
	 * Gets the base price
	 * @return The base price
	 */
	public double getBasePrice() {
		return BASE_PRICE;
	}
	
	/**
	 * Gets the beverage type
	 * @return Type of beverage
	 */
	public Type getType() {
		return beverageType;
	}
	
	/**
	 * Gets the name of the beverage
	 * @return The beverage name
	 */
	public String getBevName() {
		return beverageName;
	}
	
	/**
	 * Gets the size of the beverage
	 * @return The size of the beverage
	 */
	public Size getSize() {
		return beverageSize;
	}
	
	/**
	 * Calculates a new price by adding the size price to the base price.
	 * Small size (base price) - $2.00
	 * Medium size - $2.50
	 * Large size - $3.00
	 * @return A new price that by adding the size price to the base price
	 */
	public double addSizePrice() {
		//If the size of the drink is a small, return the regular beverage price
		if(getSize() == Size.SMALL) {
			return BASE_PRICE;
		}
		
		//If the size of the drink is a medium, return the regular price + 1 size charge
		else if(getSize() == Size.MEDIUM) {
			return BASE_PRICE + SIZE_UP_PRICE;
		}
		
		/*
		 * If the size of the drink is a large or for whatever reason can't be determined, return
		 * the regular price + 2 size charges
		 */
		else {
			return BASE_PRICE + (SIZE_UP_PRICE * 2);
		}
	}
	
	/**
	 * Represents a Beverage object in String with the format of bevName,size
	 * @return The string representation of beverage
	 */
	public String toString() {
		return (getBevName() + "," + getSize());
	}
	
	/**
	 * Checks if this Beverage equals to anotherBev
	 * @param anotherBev The other beverage to compare
	 * @return True if the name, type, and size match. False otherwise.
	 */
	public boolean equals(Object anotherBev) {
		Beverage bev2 = (Beverage)anotherBev;
		if(getBevName().equalsIgnoreCase(bev2.getBevName()) &&
			getType() == bev2.getType() &&
			getSize() == bev2.getSize()) {
				return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Calculates the beverage price
	 * @return The price of a beverage
	 */
	public abstract double calcPrice();
}
