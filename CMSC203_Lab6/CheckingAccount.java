//Create a new class called CheckingAccount that extends BankAccount
public class CheckingAccount extends BankAccount {
//Static fee that represents the cost of clearing one check
	private final double FEE = 0.15;
/*
 * Constructor that takes a name and initial amounts as parameters.
 * Should call the constructor for the superclass
 * Should initialize accountNumber to be the current value in accountNumber
 * concatenated with -10
 */
	public CheckingAccount(String name, double initialAmount) {
		super(name, initialAmount);
		super.setAccountNumber(super.getAccountNumber() + "-10");
	}
/*
 * Write a new instance method "withdraw" that overrides the withdraw method in the 
 * superclass. The method must return the same true or false that was returned
 * from the call to the withdraw method from the superclass
 */
	@Override
	public boolean withdraw(double amt) {
		return super.withdraw(amt + FEE);
	}
}
