package behavioralDP.chainOfResponsibility;

public class GeneralManager extends Approver{
    //no manager any more
    public GeneralManager() {
        super(null);
    }


    // limit
    @Override
    boolean approveLoan(int amount) {
        System.out.println("General Manager approved");
        System.out.println("***************");
        return true;
    }
}