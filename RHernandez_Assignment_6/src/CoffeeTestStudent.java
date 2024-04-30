/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Tests the methods of the Coffee class
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

class CoffeeTestStudent {
	Coffee cof1 = new Coffee("Espresso", Size.SMALL, true, true);
	Coffee cof2 = new Coffee("Latte", Size.MEDIUM, true, false);
	Coffee cof3 = new Coffee("Americano", Size.LARGE, false, true);
	Coffee cof4 = new Coffee("Cappuccino", Size.MEDIUM, false, false);
	Coffee cof5 = new Coffee("Espresso", Size.SMALL, true, true);
	
	@AfterEach
	void tearDown() throws Exception {
		cof1 = cof2 = cof3 = cof4 = cof5 = null;
	}

	//Test getExtraShot
	@Test
	void testGetExtraShot() {
		assertTrue(cof1.getExtraShot());
		assertTrue(cof2.getExtraShot());
		assertFalse(cof3.getExtraShot());
		assertFalse(cof4.getExtraShot());
	}
	//Test getExtraSyrup
	@Test
	void testGetExtraSyrup() {
		assertTrue(cof1.getExtraSyrup());
		assertFalse(cof2.getExtraSyrup());
		assertTrue(cof3.getExtraSyrup());
		assertFalse(cof4.getExtraSyrup());
	}
	//Test calcPrice
	@Test
	void testCalcPrice() {
		assertEquals(3.00,cof1.calcPrice());
		assertEquals(3.00, cof2.calcPrice());
		assertEquals(3.50, cof3.calcPrice());
		assertEquals(2.50, cof4.calcPrice());
	}
	//Test toString
	@Test
	void testToString() {
		assertEquals("Espresso,SMALL,true,true,3.0", cof1.toString());
		assertEquals("Latte,MEDIUM,true,false,3.0", cof2.toString());
		assertEquals("Americano,LARGE,false,true,3.5", cof3.toString());
		assertEquals("Cappuccino,MEDIUM,false,false,2.5", cof4.toString());
	}
	//Test equals
	@Test
	void testEquals() {
		assertTrue(cof1.equals(cof5));
		assertFalse(cof2.equals(cof3));
	}
}
