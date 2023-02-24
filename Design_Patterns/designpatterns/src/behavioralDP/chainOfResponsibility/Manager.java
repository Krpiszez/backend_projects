package behavioralDP.chainOfResponsibility;

public class Manager extends Approver{

    public Manager(Approver chief) {
        super(chief);
    }

    @Override
    boolean approveLoan(int amount) {

        //suppose that limit of manager is 500
        if(amount<500){
            System.out.println("Bank manager approved");
            System.out.println("*******************");

        } else if (chief!=null) {
            System.out.println("Amount exceeds the limit that officer can approve. You are directed to general manager");
            return chief.approveLoan(amount);
        }
        return false;
    }
}
