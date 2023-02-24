package behavioralDP.chainOfResponsibility;

public class Officer extends Approver{
    public Officer(Approver chief) {
        super(chief);
    }

    //official can approve if the limit is less than 100
    @Override
    boolean approveLoan(int amount) {
        if(amount<100){
            System.out.println("Bank office approved");
            System.out.println("*******************");

        } else if (chief!=null) {
            System.out.println("Amount exceeds the limit that officer can approve. You are directed to manager");
            return chief.approveLoan(amount);
        }
        return false;
    }
}