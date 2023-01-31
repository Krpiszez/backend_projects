package Assignment_01_24;

public class SavingsAccount extends Account{

    private double interest;

    public void setInterest(double interest) {
        System.out.println("The interest rate is: %" + interest);
        this.interest = interest;
    }

    public void addInterest(){
        this.balance += this.balance * this.interest/100;
        System.out.println("Your balance after interest is applied: " + moneyFormat.format(balance));
    }

    @Override
    public double getBalance() {
        System.out.println("Saving Account Balance is: " + moneyFormat.format(balance)); // here I only type this to see if this works fine with derived class its not necessary
        return balance;
    }
}