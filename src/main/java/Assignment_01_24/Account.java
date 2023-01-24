package Assignment_01_24;


import java.text.DecimalFormat;

public class Account {

    DecimalFormat moneyFormat = new DecimalFormat("'$'###, ##0.00");
    protected double balance; // here is the balance variable all instance of children of this class will use this variable.

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // deposit(), withdraw(), transfer() methods of parent Account class.
    // Those methods are not need to be overridden thus they will do the same thing in every derived class.
    public void deposit(double amount){ // deposit method of account class
        this.balance += amount;
        System.out.println(moneyFormat.format(amount) + " has been deposited.");
        System.out.println("New balance is: " + moneyFormat.format(balance));

    }

    public void withdraw(double amount){
        if (amount>balance){
            System.out.println("Insufficient balance! ");
        }
        this.balance -= amount;
        System.out.println(moneyFormat.format(amount) + " has been withdrawn.");
        System.out.println("New balance is: " + moneyFormat.format(balance));
    }

    public void transfer(double amount){
        this.balance -= amount;
        System.out.println(moneyFormat.format(amount) + " has been transferred.");
        System.out.println("New balance is: " + moneyFormat.format(balance));
    }

}
