package Assignment_01_24;

public class CurrentAccount extends Account{

    private double limit;

    public double setLimit(double limit){
        System.out.println("The limit of transfer transactions is: " + moneyFormat.format(limit));
        return this.limit = limit;
    }

    @Override
    public void transfer(double amount) {
        if (amount > limit){
            System.out.println("You cannot transfer amount which is greater than: " + moneyFormat.format(limit));
        }else {
        this.balance -= amount;
            System.out.println(moneyFormat.format(amount) + " has been transferred.");
            System.out.println("New balance is: " + moneyFormat.format(balance));
        }
    }

    @Override
    public double getBalance() {
        System.out.println("Current Account Balance is: " + moneyFormat.format(balance)); // here I only type this to see if this works fine with derived class its not necessary
        return balance;
    }
}
