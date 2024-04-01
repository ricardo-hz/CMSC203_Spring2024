/*
 * Class: CMSC203 CRN 30339
 * Instructor: Grigoriy Grinberg
 * Description: This class tests methods found in Property.java.
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

class PropertyTestStudent {
	Property property;

	@BeforeEach
	void setUp() throws Exception {
		property = new Property("Fake Property", "Fake City", 9999.99, "Fake Owner", 0,0,5,2);
	}

	@AfterEach
	void tearDown() throws Exception {
		property = null;
	}

	@Test
	void testGetCity() {
		assertEquals("Fake City", property.getCity());
	}
	
	@Test
	void testGetOwner() {
		assertEquals("Fake Owner", property.getOwner());
	}
	
	@Test
	void testGetPlot() {
		assertEquals(0, property.getPlot().getX());
		assertEquals(0, property.getPlot().getY());
		assertEquals(5, property.getPlot().getWidth());
		assertEquals(2, property.getPlot().getDepth());
	}
	
	@Test
	void testGetPropertyName() {
		assertEquals("Fake Property", property.getPropertyName());
	}
	
	@Test
	void testGetRentAmount() {
		assertEquals(9999.99, property.getRentAmount());
	}
	
	@Test
	void testSetCity() {
		property.setCity("Silver Spring");
		assertEquals("Silver Spring", property.getCity());
	}
	
	@Test
	void testSetOwner() {
		property.setOwner("Ricardo Hernandez");
		assertEquals("Ricardo Hernandez", property.getOwner());
	}
	
	@Test
	void testSetPropertyName() {
		property.setPropertyName("Generic Property Name");
		assertEquals("Generic Property Name", property.getPropertyName());
	}
	
	@Test
	void testSetRentAmount() {
		property.setRentAmount(500.00);
		assertEquals(500.00, property.getRentAmount());
	}
	
	@Test
	void testToString() {
		assertEquals("Fake Property,Fake City,Fake Owner,9999.99", property.toString());
	}
}
