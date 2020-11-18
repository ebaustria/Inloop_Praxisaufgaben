
public class BankAccount {
	private double balance;
	private double lineOfCredit;
	private String accountNumber;
	private AccountState state;
	
	public BankAccount(String accountNumber, double lineOfCredit) {
		if (accountNumber == null) {
			throw new NullPointerException("The account number cannot be null.");
		}
		if (accountNumber.equals("")) {
			throw new IllegalArgumentException("The account number cannot be blank.");
		}
		if (lineOfCredit < 0) {
			throw new IllegalArgumentException("The line of credit cannot be negative.");
		}
		this.accountNumber = accountNumber;
		this.lineOfCredit = lineOfCredit;
		balance = 0;
		state = new Positive();
	}
	
	public boolean payIn(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("The amount to be deposited must be positive.");
		}
		return state.payIn(amount);
	}
	
	public boolean payOff(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("The amount to be withdrawn must be positive.");
		}
		return state.payOff(amount);
	}
	
	public boolean close() {
		if (balance == 0) {
			state = new Closed();
			return true;
		}
		return false;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public String getState() {
		return state.toString();
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public void printBalance() {
		state.printBalance();
	}
	
	public void payInterest() {
		state.payInterest();
	}
	
	abstract class AccountState {
		
		public boolean payIn(double amount) {
			if (state instanceof Closed) {
				return false;
			}
			return this.payIn(amount);
		}
		
		public boolean payOff(double amount) {
			if (state instanceof Closed || state instanceof Frozen) {
				return false;
			}
			return this.payOff(amount);
		}
		
		public String toString() {
			if (state instanceof Positive) {
				return "Positive";
			}
			if (state instanceof Negative) {
				return "Negative";
			}
			if (state instanceof Frozen) {
				return "Frozen";
			}
			return "Closed";
		}
		
		public void payInterest() {
			if (state instanceof Closed) {
				throw new IllegalStateException("No interest can be paid if the account is closed.");
			}
			this.payInterest();
		}
		
		public abstract void printBalance();
	}
	
	class Negative extends AccountState {
		
		public boolean payIn(double amount) {
			if ((balance + amount) >= 0) {
				balance += amount;
				state = new Positive();
				return true;
			}
			balance += amount;
			return true;
		}
		
		public boolean payOff(double amount) {
			if ((balance - amount) == (0 - lineOfCredit)) {
				balance = balance - amount;
				state = new Frozen();
				return true;
			}
			if ((balance - amount) < (0 - lineOfCredit)) {
				return false;
			}
			balance = balance - amount;
			return true;
		}

		@Override
		public void printBalance() {
			System.out.println("Balance is NEGATIVE: " + balance + ".");
		}
		
		public void payInterest() {
			balance = balance + (balance * 0.03);
			if (Math.abs(balance) > lineOfCredit) {
				state = new Frozen();
			}
		}
	}
	
	class Closed extends AccountState {
		
		public void printBalance() {
			System.out.println("This account is CLOSED. The balance is 0.");
		}
	}
	
	class Frozen extends AccountState {
		
		public boolean payIn(double amount) {
			if ((balance + amount) >= 0) {
				balance += amount;
				state = new Positive();
				return true;
			}
			balance += amount;
			state = new Negative();
			return true;
		}
		
		public void printBalance() {
			System.out.println("Balance is NEGATIVE: " + balance + ". You need to pay in money.");
		}
		
		public void payInterest() {
			balance = balance + (balance * 0.05);
		}
	}
	
	class Positive extends AccountState {

		public boolean payIn(double amount) {
			balance = balance + amount;
			return true;
		}
		
		public boolean payOff(double amount) {
			Double result = balance - amount;
			if (Math.abs(result) == lineOfCredit) {
				balance = balance - amount;
				state = new Frozen();
				return true;
			}
			if ((balance - amount) < (0 - lineOfCredit)) {
				return false;
			}
			if ((balance - amount) < 0) {
				balance = balance - amount;
				state = new Negative();
				return true;
			}
			balance = balance - amount;
			return true;
		}
		
		@Override
		public void printBalance() {
			System.out.println("Balance is POSITIVE: " + "+" + balance + ".");
		}
		
		public void payInterest() {
			balance = (balance * 0.01) + balance;
		}
	}
}
