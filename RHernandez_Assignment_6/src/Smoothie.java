/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Represents Smoothie Beverage
 * Due: 04/29/2024
 * Platform/compiler: Windows 10 Eclipse IDE
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ricardo Hernandez
*/
public class Smoothie extends Beverage {
	private int numFruits;
	private boolean containsProtein;
	private final double FRUIT_COST = 0.50;
	private final double PROTEIN_COST = 1.50;
	
	/**
	 * Creates a Smoothie beverage using passed values
	 * @param bevName Name of the beverage
	 * @param size Size of the beverage
	 * @param numOfFruits Number of fruits to be added to the smoothie
	 * @param addProtein True if protein should be added to the smoothie. False otherwise
	 */
	Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein){
		super(bevName, Type.SMOOTHIE, size);
		numFruits = numOfFruits;
		containsProtein = addProtein;
	}
	
	/**
	 * Return number of fruits
	 * @return number of fruits
	 */
	public int getNumOfFruits() {
		return numFruits;
	}
	
	/**
	 * Indicates whether or not protein is added
	 * @return True if protein is added, false otherwise
	 */
	public boolean getAddProtein() {
		return containsProtein;
	}
	
	/**
	 * Returns the string representation of a Smoothie drink. Contains the name, size, whether or not
	 * protein has been added, the number of fruits, and price.
	 * @return A String representation of a Smoothie beverage
	 */
	@Override
	public String toString() {
		return(getBevName() + "," + getSize() + "," + getAddProtein() + "," + 
				getNumOfFruits() + "," + calcPrice());
	}
	
	/**
	 * Calculates and returns the Smoothie beverage price
	 * @return Price of Smoothie
	 */
	@Override
	public double calcPrice() {
		double price = addSizePrice();
		price += (numFruits * FRUIT_COST);
		if(getAddProtein()) {
			price += PROTEIN_COST;
		}
		return price;
	}
	
	/**
	 * Checks if this smoothie is equal to another smoothie
	 * @return True if the name, type, size, price, number of fruits, and whether or not
	 * protein has been added are the same between both smoothies. False otherwise.
	 */
	@Override
	public boolean equals(Object anotherBev) {
		Smoothie otherSmoothie = (Smoothie)anotherBev;
		boolean equals = super.equals(otherSmoothie);
		if(numFruits != otherSmoothie.getNumOfFruits() || containsProtein != otherSmoothie.getAddProtein()) {
			equals = false;
		}
		return equals;
	}
}
