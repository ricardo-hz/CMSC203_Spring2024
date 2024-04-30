/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Represents a customer
 * Due: 04/29/2024
 * Platform/compiler: Windows 10 Eclipse IDE
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ricardo Hernandez
*/
public class Customer {
	private String name;
	private int age;
	
	/**
	 * Create a customer object with the passed values
	 * @param name customer name
	 * @param age customer age
	 */
	public Customer(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	/**
	 * Create a customer object using the information of another customer
	 * @param otherCustomer The other customer to be copied from
	 */
	public Customer(Customer otherCustomer) {
		name = otherCustomer.getName();
		age = otherCustomer.getAge();
	}
	
	/**
	 * Gets the customer's age
	 * @return an int representing the customer's age
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * Change the customer's age
	 * @param age the new age of the customer
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * Get the customer's name
	 * @return A string representing the customer's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Change the customer's name
	 * @param name the new name of the customer
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * String representation of the customer in the following format:
	 * name,age
	 * @return String representation of the customer
	 */
	@Override
	public String toString() {
		return(getName() + "," + getAge());
	}
}
