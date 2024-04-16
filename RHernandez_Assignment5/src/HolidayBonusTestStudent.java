/*
 * Class: CMSC203 CRN 30339
 * Instructor: Grigoriy Grinberg
 * Description: This class tests the methods found in the HolidayBonus.java file
 * Due: 04/15/2024
 * Platform/compiler: Windows 10 Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ricardo Hernandez
*/
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HolidayBonusTestStudent {
	
	private double[][] array = 
		{
				{732.35,336.9,1172.46,1070.49,725.9,2.77},
				{-37.37,868.43,186.27,985.61},
				{175.4,361.63,468.65,961.35,1092.59,821.14},
				{1169.72,289.18,327.97,-416.54}
		};
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculateHolidayBonus() {
		double[] holidayBonus = {16000.00,8000.00,18000.00,8000.00};
		double[] holidayBonusFromClass = HolidayBonus.calculateHolidayBonus(array);
		boolean equal = true;
		for(int i = 0; i < holidayBonus.length; i++) {
			if(holidayBonus[i] != holidayBonusFromClass[i]) {
				equal = false;
			}
		}
		assertTrue(equal);
		holidayBonus = null;
	}
	
	@Test
	void testCalculateTotalHolidayBonus() {
		assertEquals(50000.00, HolidayBonus.calculateTotalHolidayBonus(array));
	}

}
