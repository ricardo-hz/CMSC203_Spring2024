/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Tests methods found in Alcohol.java
 * Due: 04/29/2024
 * Platform/compiler: Windows 10 Eclipse IDE
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ricardo Hernandez
*/
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class AlcoholTestStudent {
	Alcohol alc1 = new Alcohol("French 75", Size.SMALL, true);
	Alcohol alc2 = new Alcohol("Four Loko", Size.MEDIUM, false);
	Alcohol alc3 = new Alcohol("Absolut Watermelon", Size.LARGE, true);
	Alcohol alc4 = new Alcohol("French 75", Size.SMALL, true);
	
	@AfterEach
	void tearDown() throws Exception {
		alc1 = alc2 = alc3 = alc4 = null;
	}

	//Test calcPrice
	@Test
	void testCalcPrice() {
		assertEquals(2.60, alc1.calcPrice());
		assertEquals(2.50, alc2.calcPrice());
		assertEquals(3.60, alc3.calcPrice());
	}
	//Test toString
	@Test
	void testToString() {
		assertEquals("French 75,SMALL,true,2.6", alc1.toString());
		assertEquals("Four Loko,MEDIUM,false,2.5", alc2.toString());
		assertEquals("Absolut Watermelon,LARGE,true,3.6", alc3.toString());
		
	}
	//Test equals
	@Test
	void testEquals() {
		assertTrue(alc1.equals(alc4));
		assertFalse(alc2.equals(alc3));
	}
	//Test isWeekend
	@Test
	void testIsWeekend() {
		assertTrue(alc1.isWeekend());
		assertFalse(alc2.isWeekend());
		assertTrue(alc3.isWeekend());
	}
}
