public class Account {
    // Instance Variables
    private int accountId;
    private String accountTitle; // Name of Account Holder.
    private double openingBal;
    private String emailID;
    private double accountBal;

    // Static Variables
    private static int minBalLimit = 100;
    private static int numAccounts;

    // Constructors
    public Account(int accountId, String accountTitle, double openingBal, String emailID) {
        numAccounts++;
        this.accountId = accountId + numAccounts;
        this.accountTitle = accountTitle;
        this.openingBal = openingBal;
        accountBal = openingBal;
        this.emailID = emailID;
        deposit(openingBal);
    }
    public Account(int accountId, String accountTitle, double openingBal) {
        numAccounts++;
        this.accountId = accountId + numAccounts;
        this.accountTitle = accountTitle;
        this.openingBal = openingBal;
        accountBal = openingBal;
    }

    // Set Methods
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    public void setAccountTitle(String accountTitle) {
        this.accountTitle = accountTitle;
    }
    public void setOpeningBa(double openingBal) {
        this.openingBal = openingBal;
    }
    public boolean setAccountBal(double newAccountBa) {
        if (newAccountBa < minBalLimit) {
            return false;
        } else {
            accountBal = newAccountBa;
            return true;
        }
    }
    public static boolean setMinBalLimit(int newLimit) {
        if (newLimit >= 0) {
            minBalLimit = newLimit;
            return true;
        } else {
            System.out.println("Limit must be non-negative");
            return false;
        }
    }

    // Getter Methods
    public int getAccountId() {
        return accountId;
    }
    public String getAccountTitle() {
        return accountTitle;
    }
    public double getOpeningBal() {
        return openingBal;
    }
    public String getEmailID() {
        return emailID;
    }
    public double getAccountBal() {
        return accountBal;
    }
    public static int getNumAccount() {
        return numAccounts;
    }
    public static int getMinBalLimit() {
        return minBalLimit;
    }

    // Application Specific Methods
    public boolean deposit(double amount) {
        accountBal += amount;
        System.out.print("Current Account Balance: ");
        System.out.println(accountBal);
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount%500 == 0) {
			if (accountBal - minBalLimit >= amount) {
				accountBal =- amount;
				return true;
			}
			else {
				System.out.println("Balance limit is reached");
				return false;
			}
		}
		else {
			System.out.println("Must enter amount in multiple of 500/-Rs");
            return false;
        }
    }
}