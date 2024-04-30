/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Tests methods found in Customer.java
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

class CustomerTestStudent {
	Customer cust1;
	Customer cust2;
	@BeforeEach
	void setUp() throws Exception {
		cust1 = new Customer("Jonathan", 19);
	}

	@AfterEach
	void tearDown() throws Exception {
		cust1 = cust2 = null;
	}

	//Test getName
	@Test
	void testGetName() {
		assertEquals("Jonathan", cust1.getName());
	}
	//Test setName
	@Test
	void testSetName() {
		cust1.setName("New Name");
		assertEquals("New Name", cust1.getName());
	}
	//Test getAge
	@Test
	void testGetAge() {
		assertEquals(19, cust1.getAge());
	}
	//Test setAge
	@Test
	void testSetAge() {
		cust1.setAge(21);
		assertEquals(21, cust1.getAge());
	}
	//Test toString
	@Test
	void testToString() {
		assertEquals("Jonathan,19",cust1.toString());
	}
	//Test copy constructor
	@Test
	void testCopyConstructor() {
		cust2 = new Customer(cust1);
		assertTrue(cust2.getAge() == 19 && cust2.getName().equals("Jonathan"));
	}
}
