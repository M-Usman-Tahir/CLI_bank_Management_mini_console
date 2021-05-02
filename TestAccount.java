import java.util.*;

public class TestAccount {
    public static void main(String[] args) {
        // ArrayList to store the accunts created
        ArrayList<Account> AccList = new ArrayList<Account>();
        // Predefined accounts
        AccList.add(new Account(0, "Usman", 6000, "m336@gmail.com"));
        AccList.add(new Account(0, "Ali", 10000));

        Scanner Input = new Scanner(System.in);
        String Y_N;

        // Process
        do {
            System.out.println("\n                  Welcome to Our Banking System!!! ");
            System.out.println(  "___________________________________________________________________________");
            System.out.println(  "                       Login and Signup page");

            System.out.println("Press 1 to SignUP");
            System.out.println("Press 2 to LogIn");
            int Usr_Input = Input.nextInt();
            // For sign-up
            if (Usr_Input == 1) {
                System.out.println("\n             Enter the registration details of the account!");
                System.out.println(  "___________________________________________________________________________");
                System.out.println("Enter your Name.");
                String accountTitle = Input.next();
                System.out.println("Enter your Email (Optional). // If you don't want to input, write 'N'!");
                String emailID = Input.next();
                System.out.print("Enter your Opening Balance (Minimum 5000/-Rs required): ");
                double openingBal = Input.nextDouble();
                if (openingBal >= 5000) {
                    if (emailID.equalsIgnoreCase("N")) {
                        System.out.println("___________________________________________________________________________");
                        Account currentUser = new Account(0, accountTitle, openingBal, emailID);
                        System.out.print("\nYour Account has been Created with ID: ");
                        System.out.println(currentUser.getAccountId());
                        AccList.add(currentUser);
                    } else {
                        System.out.println("___________________________________________________________________________");
                        Account currentUser = new Account(0, accountTitle, openingBal);
                        System.out.print("\nYour Account has been Created with ID: ");
                        System.out.println(currentUser.getAccountId());
                        AccList.add(currentUser);
                    }
                } else {
                    System.out.println("\nRequest Cannot be proceeded. Check the Information you provided and Try Again.");
                }
            }
            // For log-in
            else if (Usr_Input == 2) {
                System.out.println("\nWelcome ");
                System.out.println("\nEnter Your Account ID: ");
                int accountID = Input.nextInt();
                Account search = AccList.get(accountID - 1);
                System.out.println("Press 1 if you want to View Your Account Details. ");
                System.out.println("Press 2 if you are want to Deposit Money. ");
                System.out.println("Press 3 if you want to WithDraw Money. ");
                int Action = Input.nextInt();
                if (Action == 1) {
                    System.out.println("Account ID: " + search.getAccountId());
                    System.out.println("Account Title: " + search.getAccountTitle());
                    System.out.println("Email ID: " + search.getEmailID());
                    System.out.println("Account Balance: " + search.getAccountBal());
                } else if (Action == 2) {
                    System.out.println("Enter the amount you want to Deposit: ");
                    double amount = Input.nextInt();
                    search.deposit(amount);
                    AccList.set(accountID - 1, search);
                    System.out.println("Your Account Balance Now is: " + search.getAccountBal());
                } else if (Action == 3) {
                    System.out.println("Enter the amount you want to WithDraw: ");
                    double amount = Input.nextInt();
                    if (search.withdraw(amount)) {
                        AccList.set(accountID - 1, search);
                    }
                    System.out.println("Your Account Balance Now is: " + search.getAccountBal());
                } else {
                    System.out.println("InValid Input!!!.");
                }
            }
            else {
                System.out.println("InValid Choice");
            }
            System.out.println("___________________________________________________________________________");
            System.out.println("\nDo you want to Continue? (Y/N)");
            Y_N = Input.nextLine();
        } while (Y_N.equalsIgnoreCase("Y"));
        System.out.println("See You Next Time :)");
    }
}