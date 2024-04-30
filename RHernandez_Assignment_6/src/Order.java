/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Represents an Order
 * Due: 04/29/2024
 * Platform/compiler: Windows 10 Eclipse IDE
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ricardo Hernandez
*/
import java.util.ArrayList;
import java.util.Random;

/**
 * Represents an order
 */
public class Order implements OrderInterface, Comparable<Order> {
	private int orderNumber;
	private int orderTime;
	private Day orderDay;
	private Customer customer;
	private ArrayList<Beverage> beverageList = new ArrayList<Beverage>();
	
	/**
	 * Create a new order with given values
	 * @param orderTime the time of the order
	 * @param orderDay the day of the order
	 * @param cust the customer the order belongs to
	 */
	public Order(int orderTime, Day orderDay, Customer cust) {
		/*
		 * Make sure that the orderTime passed is valid. If not it will be assigned the earliest
		 * valid order time
		 */
		if(orderTime < 8 || orderTime > 23) {
			this.orderTime = 8;
		}
		else {
			this.orderTime = orderTime;
		}
		this.orderDay = orderDay;
		this.customer = new Customer(cust);
	}
	
	/**
	 * Generate an order number
	 * @return A random number between 10000 and 90000
	 */
	public int generateOrder() {
		Random rand = new Random();
		return(rand.nextInt(90000 - 10000 + 1) + 10000);
	}
	
	//TODO validate this with prof
	/**
	 * Returns the order number
	 * @return order number
	 */
	public int getOrderNo() {
		return orderNumber;
	}
	
	public void setOrderNo(int orderNo){
		orderNumber = orderNo;
	}
	/**
	 * Returns the order time
	 * @return order time
	 */
	public int getOrderTime() {
		return orderTime;
	}
	
	/**
	 * Returns the order day
	 * @return order day
	 */
	//TODO Validate this vs getDay with prof
	public Day getOrderDay() {
		return orderDay;
	}
	
	/**
	 * Returns a deep copy of the customer
	 * @return the customer
	 */
	public Customer getCustomer() {
		return new Customer(customer);
	}
	
	/**
	 * Returns a boolean representing whether or not the order was made on a weekend
	 * @return true if the day of the order is a weekend. False otherwise
	 */
	public boolean isWeekend() {
		if(orderDay == Day.SATURDAY || orderDay == Day.SUNDAY) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Adds coffee to the order
	 */
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		beverageList.add(new Coffee(bevName, size, extraShot, extraSyrup));
	}
	
	//TODO verify
	/**
	 * Adds alcohol to the order
	 */
	public void addNewBeverage(String bevName, Size size) {
		beverageList.add(new Alcohol(bevName, size, isWeekend()));
	}
	
	/**
	 * Adds smoothie to the order
	 */
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		beverageList.add(new Smoothie(bevName, size, numOfFruits, addProtein));
	}
	
	/**
	 * Returns the beverage listed in the itemNo of the order. This method should return a shallow
	 * copy of the beverage
	 * @return The beverage at a given index or null if there is no item in the order
	 */
	public Beverage getBeverage(int itemNo) {
		if(itemNo > beverageList.size() - 1 || beverageList == null) {
			return null;
		}
		else {
			return beverageList.get(itemNo);
		}
	}
	
	/**
	 * Returns the total number of beverages ordered within this order
	 * @return total number of beverages within this order
	 */
	public int getTotalItems() {
		return beverageList.size();
	}
	
	/**
	 * Calculates and returns the total amount for this order
	 * @return total amount for this order
	 */
	public double calcOrderTotal() {
		double price = 0;
		for(int i = 0; i < beverageList.size(); i++) {
			price += beverageList.get(i).calcPrice();
		}
		return price;
	}
	
	/**
	 * Returns the number of beverages of same type in an order
	 * @param type the type of the beverage
	 * @return number of beverages of type in this order
	 */
	public int findNumOfBeveType(Type type) {
		int numOfType = 0;
		for(int i = 0; i < beverageList.size(); i++) {
			if(beverageList.get(i).getType() == type) {
				numOfType++;
			}
		}
		return numOfType;
	}
	
	/**
	 * String representation of the order in the following format:
	 * order number,order time,order day,customer name,customer age,beverage1,beverage2,...,beverageN
	 * where N represents number of beverages
	 * @return String representation of the order
	 */
	@Override
	public String toString() {
		String str = getOrderNo() + "," + getOrderTime() + "," + getOrderDay() + "," + getCustomer();
		if(beverageList.size() == 0 || beverageList == null) {
			return str;
		}
		else {
			str += ",";
			for(int i = 0; i < beverageList.size(); i++) {
				str += beverageList.get(i).toString();
			}
			return(str);
		}
	}
	
	/**
	 * Compares one order to another based on order number
	 * @return 0 if the order numbers are the same, 1 if the calling order's order number is 
	 * greater than the passed order's order number, -1 if the calling order's order number is less
	 * than the passed order's order number.
	 */
	@Override
	public int compareTo(Order anotherOrder) {
		if(getOrderNo() > anotherOrder.getOrderNo()) {
			return 1;
		}
		else if(getOrderNo() == anotherOrder.getOrderNo()) {
			return 0;
		}
		else {
			return -1;
		}
	}
}
