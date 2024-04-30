/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Tests methods found in BevShop.java
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

class BevShopTestStudent {
	BevShop bs1;
	BevShop bs2;
	@BeforeEach
	void setUp() throws Exception {
		bs1 = new BevShop();
		bs2 = new BevShop();
	}

	@AfterEach
	void tearDown() throws Exception {
		bs1 = bs2 = null;
	}
	
	//Test isValidTime
	@Test
	void testIsValidTime() {
		//bs1.orderList.add(new Order(8, Day.SUNDAY, new Customer("Test", 25)));
		bs1.startNewOrder(8, Day.MONDAY, "Test", 25);
		assertTrue(bs1.isValidTime(bs1.getOrderAtIndex(0).getOrderTime()));
		assertFalse(bs1.isValidTime(6));
		assertFalse(bs1.isValidTime(24));
	}
	//Test getMaxNumOfFruits
	@Test
	void testGetMaxNumOfFruits() {
		assertEquals(5, bs1.getMaxNumOfFruits());
	}
	//Test getMinAgeForAlcohol
	@Test
	void testGetMinAgeForAlcohol() {
		assertEquals(21, bs1.getMinAgeForAlcohol());
	}
	//Test isMaxFruit
	@Test
	void testIsMaxFruit() {
		assertTrue(bs1.isMaxFruit(bs1.getMaxNumOfFruits()));
	}
	//Test getMaxOrderForAlcohol
	@Test
	void testGetMaxOrderForAlcohol() {
		assertEquals(3,bs1.getMaxOrderForAlcohol());
	}
	//Test isEligible for More
	@Test
	void testIsEligibleForMore() {
		bs1.startNewOrder(8, Day.MONDAY, "Test", 25);
		bs2.startNewOrder(8, Day.MONDAY, "Test", 25);
		bs1.processAlcoholOrder("Alcohol 1", Size.SMALL);
		bs1.processAlcoholOrder("Alcohol 2", Size.SMALL);
		bs1.processAlcoholOrder("Alcohol 3", Size.SMALL);
		assertFalse(bs1.isEligibleForMore());
		assertTrue(bs2.isEligibleForMore());
	}
	//Test getNumOfAlcoholDrink
	@Test
	void testGetNumOfAlcoholDrink() {
		bs1.startNewOrder(8, Day.MONDAY, "Test", 25);
		bs2.startNewOrder(8, Day.MONDAY, "Test", 25);
		bs1.processAlcoholOrder("Alcohol 1", Size.SMALL);
		bs1.processAlcoholOrder("Alcohol 2", Size.SMALL);
		bs1.processAlcoholOrder("Alcohol 3", Size.SMALL);
		assertEquals(3, bs1.getNumOfAlcoholDrink());
		assertEquals(0, bs2.getNumOfAlcoholDrink());
	}
	//Test isValidAge
	@Test
	void testIsValidAge() {
		bs1.startNewOrder(8, Day.MONDAY, "Test", 25);
		bs2.startNewOrder(8, Day.MONDAY, "Test", 19);
		assertTrue(bs1.isValidAge(bs1.getCurrentOrder().getCustomer().getAge()));
		assertFalse(bs2.isValidAge(bs2.getCurrentOrder().getCustomer().getAge()));
	}
	//Test startNewOrder
	@Test
	void testStartNewOrder() {
		bs1.startNewOrder(8, Day.MONDAY, "Test", 25);
		assertEquals(1, bs1.totalNumOfMonthlyOrders());
		assertEquals(0, bs2.totalNumOfMonthlyOrders());
	}
	//Test processCoffeeOrder
	//TODO RETURN
	//@Test
	void testProcessCoffeeOrder() {
		bs1.startNewOrder(8, Day.MONDAY, "Test", 25);
		bs1.processCoffeeOrder("Test", Size.SMALL, false, false);
		//bs1.getCurrentOrder().addNewBeverage("Test", Size.SMALL, false, false);
		//bs1.processCoffeeOrder("Test", Size.SMALL, false, false);
		assertEquals(Type.COFFEE, bs1.getCurrentOrder().getBeverage(0).getType());
	}
	//Test processAlcoholOrder
	//Test processSmoothieOrder
	//Test findOrder
	void testFindOrder() {
		bs1.startNewOrder(8, Day.MONDAY, "Test", 25);
		bs1.startNewOrder(8, Day.MONDAY, "Test", 25);
		assertEquals(0, bs1.findOrder(0));
		assertEquals(1, bs1.findOrder(0));
	}
	//Test totalOrderPrice
	@Test
	void testTotalOrderPrice() {
		bs1.startNewOrder(8, Day.MONDAY, "Test", 25);
		bs1.processAlcoholOrder("Name", Size.SMALL);
		bs1.processCoffeeOrder("Name", Size.MEDIUM, false, false);
		assertEquals(4.5, bs1.totalOrderPrice(0));
	}
	//Test totalMonthlySales
	void testTotalMonthlySales() {
		bs1.startNewOrder(8, Day.MONDAY, "Test", 25);
		bs1.startNewOrder(8, Day.MONDAY, "Test", 25);
		bs1.getOrderAtIndex(0).addNewBeverage("Test", Size.MEDIUM);
		bs1.getOrderAtIndex(1).addNewBeverage("Test", Size.MEDIUM);
		assertEquals(1, bs1.totalMonthlySale());
	}
	//Test totalNumOfMonthlyOrders
	@Test 
	void TestTotalNumOfMonthlyOrders(){
		bs1.startNewOrder(8, Day.MONDAY, "Test", 25);
		bs1.startNewOrder(8, Day.MONDAY, "Test", 25);
		assertEquals(2,bs1.totalNumOfMonthlyOrders());
	}
	//Test getCurrentOrder
	@Test
	void testGetCurrentOrder() {
		bs1.startNewOrder(8, Day.MONDAY, "Test", 25);
		assertEquals("Test",bs1.getCurrentOrder().getCustomer().getName());
		assertEquals(25,bs1.getCurrentOrder().getCustomer().getAge());
	}
	//Test getOrderAtIndex
	//Test sortOrders
	//Test toString
	@Test
	void testToString() {
		bs1.startNewOrder(8, Day.TUESDAY, "Test1", 26);
		bs1.startNewOrder(8, Day.MONDAY, "Test2", 25);
		assertEquals("0,8,TUESDAY,Test1,26,0.0,0,8,MONDAY,Test2,25,0.0",bs1.toString());
	}

}
