package assignment_02_07;

public class EmployeeRunner {

    public static void main(String[] args) {
        Employee developer = new Developer();
        developer.getStatus("");
        developer.getStatus("Developer Task");

        Employee seniorDeveloper = new SeniorDeveloper();
        seniorDeveloper.getStatus("");
        seniorDeveloper.getStatus("Senior Developer Task");

        Employee tester = new Tester();
        tester.getStatus("");
        tester.getStatus("Tester Task");

    }

}
