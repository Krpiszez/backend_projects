package Assignment_01_24;

public class BankRunner {

    public static void main(String[] args) {

        SavingsAccount savAcc = new SavingsAccount();
        CurrentAccount curAcc = new CurrentAccount();

        savAcc.setBalance(1000);
        System.out.println("Your savings balance is: " + savAcc.balance);
        curAcc.setBalance(2000);
        System.out.println("Your current balance is: " + curAcc.balance);

        savAcc.setInterest(25);
        savAcc.addInterest();
        savAcc.deposit(1000);
        savAcc.transfer(250);
        savAcc.withdraw(1400);


        curAcc.setLimit(1000);
        curAcc.deposit(2750);
        curAcc.transfer(1250);
        curAcc.withdraw(1500);

        savAcc.getBalance();
        curAcc.getBalance();

    }
}