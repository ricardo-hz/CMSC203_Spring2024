/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Represents a Coffee beverage
 * Due: 04/29/2024
 * Platform/compiler: Windows 10 Eclipse IDE
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ricardo Hernandez
*/
public class Coffee extends Beverage {
	private boolean containsExtraShot;
	private boolean containsExtraSyrup;
	private double EXTRA_COST = 0.50;
	
	/**
	 * Creates a Coffee object using the given values
	 * @param bevName beverage name
	 * @param size beverage size
	 * @param extraShot true if extra coffee shot added, false otherwise
	 * @param extraSyrup true if extra syrup added, false otherwise
	 */
	Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup){
		super(bevName, Type.COFFEE, size);
		containsExtraShot = extraShot;
		containsExtraSyrup = extraSyrup;
	}
	
	/**
	 * Indicates whether or not extra shot is added
	 * @return True if the drink has an extra shot. False otherwise
	 */
	public boolean getExtraShot() {
		return containsExtraShot;
	}
	
	/**
	 * Indicates whether or not extra syrup is added
	 * @return True if the drink has extra syrup. False otherwise
	 */
	public boolean getExtraSyrup() {
		return containsExtraSyrup;
	}
	
	/**
	 * Calculates the price based on base price, size, extra coffee shot, and extra syrup
	 * @return the price of the coffee
	 */
	@Override
	public double calcPrice() {
		double price = addSizePrice();
		if (containsExtraShot) {
			price += EXTRA_COST;
		}
		if (containsExtraSyrup) {
			price += EXTRA_COST;
		}
		return price;
	}
	
	/**
	 * Represents a Coffee beverage in the following String format:
	 * name,size,extra shot(TRUE/FALSE),extra syrup(TRUE/FALSE), and the price
	 * @return String representation of a coffee
	 */
	@Override
	public String toString() {
		return(getBevName() + "," + getSize() + "," + getExtraShot() + 
				"," + getExtraSyrup() + "," + calcPrice());
	}
	
	/**
	 * Check if this Coffee equals another Coffee
	 * @return True if the name, type, size, price, and extras are all the same between the
	 * two coffees. False otherwise
	 */
	@Override
	public boolean equals(Object otherCoffee) {
		Coffee coffee2 = (Coffee)otherCoffee;
		boolean equals = super.equals(coffee2);
		if (containsExtraSyrup != coffee2.getExtraSyrup() || containsExtraShot != coffee2.getExtraShot()) {
			equals = false;
		}
		return equals;
	}
}
