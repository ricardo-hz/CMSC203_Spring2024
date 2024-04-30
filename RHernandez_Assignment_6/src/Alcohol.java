/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Represents Alcohol Beverage
 * Due: 04/29/2024
 * Platform/compiler: Windows 10 Eclipse IDE
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ricardo Hernandez
*/

public class Alcohol extends Beverage{
	private boolean offeredOnWeekend;
	private final double WEEKEND_PRICE = 0.60;
	
	/**
	 * Creates an Alcohol beverage using given values
	 * @param bevName Beverage name
	 * @param size Beverage size
	 * @param isWeekend Whether or not the beverage is offered on the weekend.
	 */
	Alcohol(String bevName, Size size, boolean isWeekend){
		super(bevName, Type.ALCOHOL, size);
		offeredOnWeekend = isWeekend;
	}
	
	/**
	 * Calculates the price of the alcohol
	 * @return the price of an alcohol beverage
	 */
	@Override
	public double calcPrice() {
		double price = addSizePrice();
		if(offeredOnWeekend) {
			price += WEEKEND_PRICE;
		}
		return price;
	}
	
	/**
	 * String representation of Alcohol beverage in the following format:
	 * name,size,offered on weekend(TRUE/FALSE), price
	 * @return A string containing the information of an alcohol beverage
	 */
	@Override
	public String toString() {
		return(getBevName() + "," + getSize() + "," + isWeekend() + "," + calcPrice());
	}
	
	/**
	 * Checks if this Alcohol beverage is equal to another alcohol beverage
	 * @return True if the name, type, size, price, and whether the alcohol is offered on the weekend are all
	 * the same as the other alcohol beverage. False otherwise.
	 */
	@Override
	public boolean equals(Object otherAlcohol) {
		Alcohol otherAlc = (Alcohol)otherAlcohol;
		boolean equals = super.equals(otherAlc);
		if(offeredOnWeekend != otherAlc.isWeekend()) {
			equals = false;
		}
		return equals;
	}
	
	/**
	 * Returns true if the alcohol is offered on weekends, false otherwise
	 * @return True if alcohol offered on weekends, false otherwise
	 */
	public boolean isWeekend() {
		return offeredOnWeekend;
	}
}
