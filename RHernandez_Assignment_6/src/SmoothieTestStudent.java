/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Tests methods found in Smoothie.java
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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SmoothieTestStudent {
	Smoothie sm1 = new Smoothie("Raspberry Banana", Size.SMALL, 0, true);
	Smoothie sm2 = new Smoothie("Strawberry Kiwi", Size.MEDIUM, 1, false);
	Smoothie sm3 = new Smoothie("Pineapple Mango", Size.LARGE, 2, false);
	Smoothie sm4 = new Smoothie("Raspberry Banana", Size.SMALL, 0, true);
	
	@AfterEach
	void tearDown() throws Exception {
		sm1 = sm2 = sm3 = sm4 = null;
	}

	//Test getNumOfFruits
	@Test
	void testGetNumOfFruits() {
		assertEquals(0,sm1.getNumOfFruits());
		assertEquals(1, sm2.getNumOfFruits());
		assertEquals(2, sm3.getNumOfFruits());
	}
	//Test getAddProtein
	@Test
	void testAddProtein() {
		assertTrue(sm1.getAddProtein());
		assertFalse(sm2.getAddProtein());
		assertFalse(sm3.getAddProtein());
	}
	//Test toString
	@Test
	void testToString() {
		assertEquals("Raspberry Banana,SMALL,true,0,3.5", sm1.toString());
		assertEquals("Strawberry Kiwi,MEDIUM,false,1,3.0", sm2.toString());
		assertEquals("Pineapple Mango,LARGE,false,2,4.0", sm3.toString());
	}
	//Test calcPrice
	@Test
	void testCalcPrice() {
		assertEquals(3.50, sm1.calcPrice());
		assertEquals(3.00, sm2.calcPrice());
		assertEquals(4.00, sm3.calcPrice());
	}
	//Test equals
	@Test
	void testEquals() {
		assertTrue(sm1.equals(sm4));
		assertFalse(sm2.equals(sm3));
	}
}
