package Assignment_01_24;

public class SavingsAccount extends Account{

    private double interest;

    public void addInterest(int interest){
        this.interest += this.interest * interest/100;
    }
}
