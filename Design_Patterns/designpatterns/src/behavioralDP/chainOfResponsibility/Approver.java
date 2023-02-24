package behavioralDP.chainOfResponsibility;

public abstract class Approver{

    Approver chief;

    //constructor
    public Approver(Approver chief) {
        this.chief = chief;
    }

    abstract boolean approveLoan(int amount);
}
