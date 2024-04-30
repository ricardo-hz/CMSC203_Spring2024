import java.util.Scanner;

public class BevShopDriverApp {
	public static void main(String[] args) {
		char newOrder = 'y';
		Scanner scan = new Scanner(System.in);
		String name;
		int age;
		
		System.out.println("The current order in process can have at most 3 alcoholic beverages.");
		System.out.println("The minimum age to order alcohol drink is 21");
		System.out.print("Would you like to start a new order? (Y/N): ");
		newOrder = scan.nextLine().charAt(0);
		while(newOrder == 'y' || newOrder == 'Y'){
			System.out.println("Your total order for now is 0.0");
			System.out.print("Please enter your name: ");
			name = scan.nextLine();
			System.out.print("Please enter your age: ");
			age = scan.nextInt();
			if(age >= 21) {
				
			}
			
			System.out.println("Would you like to start a new order? (Y/N)");
			newOrder = scan.nextLine().charAt(0);
		}
	}
}
