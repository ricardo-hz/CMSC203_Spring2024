/*
 * Class: CMSC203 CRN 30339
 * Instructor: Grigoriy Grinberg
 * Description: This class tests the methods found in Plot.java
 * Due: 04/01/2024
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

class PlotTestStudent {
	private Plot plot1, plot2;

	@BeforeEach
	public void setUp() throws Exception {
		plot1 = new Plot();
		plot2 = new Plot();
		
	}

	@AfterEach
	public void tearDown() throws Exception {
		plot1 = plot2 = null;
	}
	
	@Test
	void testLeftOverlap() {
		plot1.setAll(3,5,7,6);
		plot2.setAll(2,5,2,6);
		assertTrue(plot2.overlaps(plot1));
	}
	
	@Test
	void testRightOverlap() {
		plot1.setAll(3, 5, 7, 6);
		plot2.setAll(9, 5, 2, 6);
		assertTrue(plot2.overlaps(plot1));
	}
	
	@Test
	void testTopOverlap() {
		plot1.setAll(3,5,7,6);
		plot2.setAll(3, 10, 7, 3);
		assertTrue(plot2.overlaps(plot1));
	}
	
	@Test
	void testBottomOverlap() {
		plot1.setAll(3,5,7,6);
		plot2.setAll(3, 3, 7, 3);
		assertTrue(plot2.overlaps(plot1));
	}
	
	//The next 4 tests should not return true as plots aren't overlapping
	@Test
	void testTouchingBottom() {
		plot1.setAll(3,5,7,6);
		plot2.setAll(3, 3, 7, 2);
		assertFalse(plot2.overlaps(plot1));
	}
	
	@Test
	void testTouchingLeft() {
		plot1.setAll(3,5,7,6);
		plot2.setAll(1, 5, 2, 6);
		assertFalse(plot2.overlaps(plot1));
	}
	
	@Test
	void testTouchingRight() {
		plot1.setAll(3,5,7,6);
		plot2.setAll(10, 5, 3, 6);
		assertFalse(plot2.overlaps(plot1));
	}
	
	@Test
	void testTouchingTop() {
		plot1.setAll(3,5,7,6);
		plot2.setAll(3, 11, 7, 2);
		assertFalse(plot2.overlaps(plot1));
	}
	
	@Test
	void testEncompassing() {
		plot1.setAll(3, 5, 7, 6);
		plot2.setAll(5, 7, 3, 3);
		assertTrue(plot1.encompasses(plot2));
		
		plot1.setAll(3,5,7,6);
		plot2.setAll(3, 11, 7, 2);
		assertFalse(plot1.encompasses(plot2));
	}
	
	@Test
	void testToString() {
		plot1.setAll(3,5,7,6);
		assertEquals("3,5,7,6", plot1.toString());
	}
}
