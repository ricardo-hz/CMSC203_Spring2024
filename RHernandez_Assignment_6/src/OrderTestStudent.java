/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Tests methods found in Order.java
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

class OrderTestStudent {
	Order or1;
	Order or2;
	@BeforeEach
	void setUp() throws Exception {
		or1 = new Order(8, Day.SUNDAY, new Customer("Jonathan Smith", 19));
		or2 = new Order(23, Day.TUESDAY, new Customer("Sarah Hare", 25));
	}

	@AfterEach
	void tearDown() throws Exception {
		or1 = or2 = null;
	}

	//Test adding alcohol
	@Test
	void testAddNewAlcoholBeverage() {
		or1.addNewBeverage("Moscow Mule", Size.MEDIUM);
		assertEquals("Moscow Mule,MEDIUM,true,3.1", or1.getBeverage(0).toString());
	}
	//Test adding coffee
	@Test
	void testAddNewCoffeeBeverage() {
		or2.addNewBeverage("Mocha", Size.LARGE, true, true);
		assertEquals("Mocha,LARGE,true,true,4.0",or2.getBeverage(0).toString());
	}
	//Test adding smoothie
	@Test
	void testAddNewSmoothieBeverage() {
		or1.addNewBeverage("Raspberry Slush", Size.SMALL, 5, true);
		assertEquals("Raspberry Slush,SMALL,true,5,6.0",or1.getBeverage(0).toString());
	}
	//Test calculating order total
	@Test
	void testCalcOrderTotal() {
		or1.addNewBeverage("Random Alcoholic Beverage", Size.SMALL);
		or1.addNewBeverage("Random Smoothie Beverage", Size.MEDIUM, 2, false);
		or1.addNewBeverage("Random Coffee Beverage", Size.LARGE, true, true);
		assertEquals(or1.getBeverage(0).calcPrice() + or1.getBeverage(1).calcPrice() + 
				or1.getBeverage(2).calcPrice(), or1.calcOrderTotal());
		assertEquals(0.0,or2.calcOrderTotal());
	}
	//Test comparing orders
	@Test
	void testCompareTo() {
		assertEquals(0, or1.compareTo(or2));
	}
	//Test finding number of beverage type
	@Test
	void testFindNumOfBeveType() {
		or1.addNewBeverage("Random Alcoholic Beverage", Size.SMALL);
		or1.addNewBeverage("Random Smoothie Beverage", Size.MEDIUM, 2, false);
		or1.addNewBeverage("Random Smoothie Beverage", Size.MEDIUM, 2, false);
		assertEquals(0, or1.findNumOfBeveType(Type.COFFEE));
		assertEquals(1, or1.findNumOfBeveType(Type.ALCOHOL));
		assertEquals(2, or1.findNumOfBeveType(Type.SMOOTHIE));

	}
	//Test generateOrder
	@Test
	void testGenerateOrder() {
		assertTrue(or1.generateOrder() >= 10000 && or1.generateOrder() <= 90000);
		assertFalse(or2.generateOrder() < 10000 || or2.generateOrder() > 90000);
	}
	//Test getBeverage
	@Test
	void testGetBeverage() {
		or1.addNewBeverage("Raspberry Slush", Size.SMALL, 5, true);
		or2.addNewBeverage("Mocha", Size.LARGE, true, true);
		assertEquals("Raspberry Slush,SMALL,true,5,6.0",or1.getBeverage(0).toString());
		assertEquals("Mocha,LARGE,true,true,4.0",or2.getBeverage(0).toString());
	}
	//Test getCustomer
	@Test
	void testGetCustomer() {
		assertEquals(or1.getCustomer().toString(), "Jonathan Smith,19");
		/*
		 * Ensure that the returned customer is a deep copy(Changing the original customer's attributes
		 * should not affect the customer copy)
		 */
		Customer custCopy = or2.getCustomer();
		assertNotEquals(or2.getCustomer(), custCopy);
		custCopy = null;
	}
	//Test getOrderDay
	@Test
	void testGetOrderDay() {
		assertTrue(or1.getOrderDay() == Day.SUNDAY);
		assertFalse(or2.getOrderDay() != Day.TUESDAY);
	}
	//Test getOrderNo
	@Test
	void testGetOrderNo() {
		assertEquals(0, or1.getOrderNo());
		assertEquals(0, or2.getOrderNo());
	}
	//Test getOrderTime
	@Test
	void testGetOrderTime() {
		Order or3 = new Order(5, Day.FRIDAY, new Customer("Placeholder",19));
		assertEquals(8,or3.getOrderTime());
		assertEquals(8, or1.getOrderTime());
		assertEquals(23, or2.getOrderTime());
		or3 = null;
	}
	//Test isWeekend
	@Test
	void testIsWeekend() {
		assertTrue(or1.isWeekend());
		assertFalse(or2.isWeekend());
	}
	//Test toString
	@Test
	void testToString() {
		or2.addNewBeverage("Random Alcoholic Beverage", Size.SMALL);
		or2.addNewBeverage("Random Smoothie Beverage", Size.MEDIUM, 2, false);
		or2.addNewBeverage("Random Coffee Beverage", Size.LARGE, true, false);
		assertEquals("0,8,SUNDAY,Jonathan Smith,19", or1.toString());
		String str = "0,23,TUESDAY,Sarah Hare,25,";
		str += or2.getBeverage(0).toString();
		str += or2.getBeverage(1).toString();
		str += or2.getBeverage(2).toString();
		assertEquals(str,or2.toString());
	}
}
