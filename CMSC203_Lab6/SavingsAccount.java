//Create a new class called SavingsAccount that extends bank account
public class SavingsAccount extends BankAccount{
	/*
	 * It should contain an instance variable called rate that represents
	 * the annual interest rate. Set it equal to 2.5%
	 */
	private final double RATE = 0.025;
	/*
	 * It should also have an instance variable called savingsNumber initialized to 0. In this bank,
	 * you have one account number, but can haver several savings accounts with that same number. Each individual
	 * savings account is identified by the number following a dash.
	 */
	private int savingsNumber = 0;
	/*
	 * An instance variable called accountNumber that will hide the accountNumber from the superclass
	 * should be in this class.
	 */
	private String accountNumber;
	/*
	 * Write a constructor that takes a name and an initial balance as parameters and calls the constructor
	 * from the superclass.
	 */
	public SavingsAccount(String name, double initialBalance) {
		super(name, initialBalance);
		accountNumber = (super.getAccountNumber() + "-" + savingsNumber++);
	}
	/*
	 * Write a method called postInterest that has no parameters and returns no value.
	 */
	public void postInterest() {
		super.deposit(super.getBalance() * (RATE/12));
	}
	/*
	 * Write a method that overrides the getrAccountNumber method in the superclass.
	 */
	@Override
	public String getAccountNumber()
	{
		return accountNumber;
	}
	/*
	 * Write a copy constructor that creates another savings account for the same person.
	 */
	public SavingsAccount(BankAccount originalAccount, double initialBalance) {
		super(originalAccount, initialBalance);
		savingsNumber++;
		accountNumber = (super.getAccountNumber() + "-" + savingsNumber);
	}
}
