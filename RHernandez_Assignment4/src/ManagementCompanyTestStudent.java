/*
 * Class: CMSC203 CRN 30339
 * Instructor: Grigoriy Grinberg
 * Description: This class tests the methods found in ManagementComapny.java
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

class ManagementCompanyTestStudent {
	ManagementCompany mgmtcomp;
	
	@BeforeEach
	void setUp() throws Exception {
		mgmtcomp = new ManagementCompany("Test Company", "ID1234", 0.5);
	}

	@AfterEach
	void tearDown() throws Exception {
		mgmtcomp = null;
	}

	@Test
	void testAddPropertyBasic() {
		assertEquals(0, mgmtcomp.addProperty("Test namne", "Test City", 200.00, "Test Owner"));
		assertEquals(1, mgmtcomp.addProperty("Test namne", "Test City", 200.01, "Test Owner"));
		assertEquals(2, mgmtcomp.addProperty("Test namne", "Test City", 200.02, "Test Owner"));
		assertEquals(3, mgmtcomp.addProperty("Test namne", "Test City", 200.03, "Test Owner"));
		assertEquals(4, mgmtcomp.addProperty("Test namne", "Test City", 200.04, "Test Owner"));
		assertEquals(-1, mgmtcomp.addProperty("Test namne", "Test City", 200.05, "Test Owner"));
	}
	
	@Test
	void testAddPropertyWithPlot() {
		mgmtcomp = new ManagementCompany("Test Company", "ID1234", 0.5,1,1,5,5);
		assertEquals(-3, mgmtcomp.addProperty("Test namne", "Test City", 200.00, "Test Owner",7,6,5,5));
		assertEquals(0, mgmtcomp.addProperty("Test namne", "Test City", 200.00, "Test Owner",2,2,3,3));
		assertEquals(1, mgmtcomp.addProperty("Test namne", "Test City", 200.00, "Test Owner",1,1,3,3));
		mgmtcomp = null;
		
	}
	
}
