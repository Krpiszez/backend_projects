package behavioralDP.chainOfResponsibility;

public class ChainOfResponsibilityRunner {

    public static void main(String[] args) {

        chainOfResponsibility();

    }

    static void chainOfResponsibility(){
        Approver generalManager = new GeneralManager();

        Approver menager = new Manager(generalManager);

        Approver officer = new Officer(menager);

        System.out.println("Limits for loan...");
        System.out.println("For officer max limit is < 100");
        System.out.println("For manager max limit is < 500");
        System.out.println("For gm no limit");
        System.out.println("request amount is 50");
        officer.approveLoan(50);

        System.out.println("request amount is 450");
        officer.approveLoan(450);

        System.out.println("request amount is 1500");
        officer.approveLoan(1500);



    }
}
