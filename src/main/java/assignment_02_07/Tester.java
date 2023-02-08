package assignment_02_07;

public class Tester extends Employee{

    private String name = "Tester";
    public void getStatus(String task) {
        if (task.isEmpty()){
            System.out.println(this.name + " is Waiting for Assignment");
        }else {
            this.task = task;
            System.out.println(this.name + " is Working on " + this.task + " Assignment");
        }
    }
}
