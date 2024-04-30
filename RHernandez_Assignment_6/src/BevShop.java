/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Represents a BevShop
 * Due: 04/29/2024
 * Platform/compiler: Windows 10 Eclipse IDE
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ricardo Hernandez
*/
import java.util.ArrayList;

/**
 * Represents Bradley's Beverage Shop
 */
public class BevShop implements BevShopInterface{
	private int numAlcoholicDrinks = 0;
	//TODO verify
	private int numOrders = 0;
	private int currentOrderIndex = -1;
	private ArrayList<Order> orderList = new ArrayList<>();
	//Time, orderday, customer, list of beverages???
	
	public BevShop() {
		
	}
	
	/**
	 * Checks if the time is valid
	 * @param time represents the time
	 * @return true if time is within valid range (8-23), false otherwise
	 */
	public boolean isValidTime(int time) {
		if(time >= 8 && time <= 23) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Returns the constant value for the maximum number of fruits
	 * @return maximum number of fruits
	 */
	public int getMaxNumOfFruits() {
		return MAX_FRUIT;
	}
	
	/**
	 * Returns the constant value for the minimum age for ordering alcohol beverage
	 * @return min age for alcohol order
	 */
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}
	
	/**
	 * Checks to see if more fruit can be added
	 * @return true if the passed param exceeds max fruit allowed, false otherwise
	 */
	public boolean isMaxFruit(int numOfFruits) {
		if(numOfFruits >= getMaxNumOfFruits()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Returns constant maximum of alcohol beverages per order offered by beverage shop
	 * @returns max number of alcohol beverages allowed
	 */
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}
	
	/**
	 * Checks if the number of alcohol beverages for the current order has reached the maximum
	 * @return
	 */
	public boolean isEligibleForMore() {
		if(getNumOfAlcoholDrink()< getMaxOrderForAlcohol()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Returns the number of alcohol drinks in the current order
	 * @return current number of alcoholic drinks
	 */
	public int getNumOfAlcoholDrink() {
		return numAlcoholicDrinks;
	}
	
	/**
	 * Checks the valid age for the alcohol drink
	 * @return true if age is greater than or equal to minimum eligible age, false otherwise
	 */
	public boolean isValidAge(int age) {
		if(age >= getMinAgeForAlcohol()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Creates a new order, no beverage is added to the order yet
	 * @param time time of the order
	 * @param day day of the order
	 * @param customerName name of customer
	 * @param age age of customer
	 */
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		orderList.add(new Order(time, day, new Customer(customerName, customerAge)));
		numOrders++;
		currentOrderIndex++;
	}
	
	/**
	 * Adds a coffee beverage to the current order
	 * @param bevName beverage name
	 * @param size beverage size
	 * @param extraShot true if coffee has extra shot, false otherwise
	 * @param extraSyrup true if coffee has extra syrup, false otherwise
	 */
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		orderList.get(currentOrderIndex).addNewBeverage(bevName, size, extraShot, extraSyrup);
	}
	
	/**
	 * Adds an alcohol beverage to the current order if the maximum amount of
	 * alcohol beverages hasn't been reached
	 * @param bevName beverage name
	 * @param bevSize beverage size
	 */
	public void processAlcoholOrder(String bevName, Size size) {
		if(isEligibleForMore()) {
			orderList.get(currentOrderIndex).addNewBeverage(bevName, size);
		}
		numAlcoholicDrinks++;
	}
	
	/**
	 * Adds a smoothie beverage to current order. Will add maximum amount of fruits if number passed
	 * is greater than the maximum amount of fruits allowed
	 * @param bevName beverage name
	 * @param size beverage size
	 * @param numOfFruits the number of fruits to add
	 * @param addProtein true if the smoothie has protein, false otherwise 
	 */
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
		if(numOfFruits <= MAX_FRUIT) {
			orderList.get(currentOrderIndex).addNewBeverage(bevName, size, numOfFruits, addProtein);
		}
		else {
			orderList.get(currentOrderIndex).addNewBeverage(bevName, size, MAX_FRUIT, addProtein);
		}
	}
	
	/**
	 * locate an order based on the order number
	 * @param orderNo the order number
	 * @return the index of the order in the list of Orders if found or -1 if not found
	 */
	public int findOrder(int orderNo) {
		int index = -1;
		for(int i = 0; i < orderList.size(); i++) {
			if(orderList.get(i).getOrderNo() == orderNo) {
				index = i;
			}
		}
		return index;
	}
	
	/**
	 * locates an order in the list of orders and returns the total value on the order.
	 * @param orderNo the order number
	 * @return the calculated price on this order
	 */
	public double totalOrderPrice(int orderNo) {
		double price = 0;
		for(int i = 0; i < orderList.size(); i++) {
			price += orderList.get(orderNo).calcOrderTotal();
		}
		return price;
	}
	
	/**
	 * Calculates the total sale of all the orders for this beverage shop
	 * @return the total sale of all the orders
	 */
	public double totalMonthlySale() {
		double price = 0;
		for(int i = 0; i < orderList.size(); i++) {
			price += orderList.get(i).calcOrderTotal();
			//price += getOrderAtIndex(i).calcOrderTotal();
		}
		return price;
	}
	
	/**
	 * Returns total numbers of orders within the month
	 * @return total numbers of orders within the month
	 */
	public int totalNumOfMonthlyOrders() {
		return orderList.size();
	}
	
	//TODO verify this
	/**
	 * Returns the current order located in the index in the list of orders. Note: this method returns the shallow copy of the order
	 * @return A shallow copy of the current order
	 */
	public Order getCurrentOrder() {
		/*Order orderCopy = */ return new Order(orderList.get(currentOrderIndex).getOrderTime(), orderList.get(currentOrderIndex).getOrderDay(), 
				orderList.get(currentOrderIndex).getCustomer());
		//return orderList.get(currentOrderIndex).clone();
	}
	
	/**
	 * Returns Order in the list of orders at the index. Note: this method returns the shallow
	 * copy of the order
	 * @param index the order index
	 * @return Order in the list of orders at the index
	 */
	public Order getOrderAtIndex(int index) {
		Order copyOrder = getCurrentOrder();
		if(index < orderList.size() /*- 1*/) {
			copyOrder =  new Order(orderList.get(index).getOrderTime(), orderList.get(index).getOrderDay(), 
					orderList.get(index).getCustomer());
		}
		return copyOrder;
	}
	
	/**
	 * Sorts the orders within this bevShop using the 
	 */
	public void sortOrders() {
		int minIndex;
		Order tempOrder;
		for(int i  = 0; i < orderList.size() - 1; i++) {
			minIndex = i;
			for(int j = i + 1; j < orderList.size(); j++) {
				if(orderList.get(j).compareTo(orderList.get(minIndex)) < 0) {
					minIndex = j;
				}
			}
			tempOrder = new Order(orderList.get(i).getOrderTime(), orderList.get(i).getOrderDay(), 
					new Customer(orderList.get(i).getCustomer().getName(), orderList.get(i).getCustomer().getAge()));
			orderList.set(minIndex, orderList.get(i));
			orderList.set(i, tempOrder);
		}
	}
	
	/**
	 * Returns the string representation of all the orders and the total
	 * monthly sale
	 * @return the information of all the orders
	 */
	@Override
	public String toString() {
		String str = "";
		String newStr = str;
		if(!orderList.isEmpty()) {
			for(int i = 0; i < orderList.size(); i++) {
				str += (orderList.get(i).toString() + "," + totalMonthlySale() + ",");
			}
			newStr = str.substring(0, str.length() - 1);
		}
		return newStr;
	}
}
