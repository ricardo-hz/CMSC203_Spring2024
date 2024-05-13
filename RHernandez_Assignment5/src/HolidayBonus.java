/*
 * Class: CMSC203 CRN 30339
 * Instructor: Grigoriy Grinberg
 * Description: This class calculates the holiday bonuses awarded to each store
 * and the total dollar amount of holiday bonuses awarded.
 * Due: 04/15/2024
 * Platform/compiler: Windows 10 Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ricardo Hernandez
*/
public class HolidayBonus {
	final static private double LOW_BONUS = 1000;
	final static private double REG_BONUS = 2000;
	final static private double HIGH_BONUS = 5000;
	
	public static double[] calculateHolidayBonus(double[][] data) {
		//Holds the holiday bonus for each store
		double[] holidayBonus = new double[data.length];
		//Loop through array data
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				//Only award bonuses when amt sold is greater than 0
				if(data[row][col] > 0){
					//Add bonus to store with lowest sales in category
					if(data[row][col] == TwoDimRaggedArrayUtility.getLowestInColumn(data, col)) {
						holidayBonus[row] += LOW_BONUS;
					}
					//Add bonus to store with highest sales in category
					else if(data[row][col] == TwoDimRaggedArrayUtility.getHighestInColumn(data, col)) {
						holidayBonus[row] += HIGH_BONUS;
					}
					//Add bonus to store with all other stores
					else {
						holidayBonus[row] += REG_BONUS;
					}
				}
			}
		}
		return holidayBonus;
	}
	
	
	public static double calculateTotalHolidayBonus(double[][] data) {
		double totalHolidayBonus = 0;
		//Iterate  through array, adding to total variable
		for(int i = 0; i < calculateHolidayBonus(data).length; i++) {
			totalHolidayBonus += calculateHolidayBonus(data)[i];
		}
		return totalHolidayBonus;
	}
}
