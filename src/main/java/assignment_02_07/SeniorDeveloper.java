package assignment_02_07;

public class SeniorDeveloper extends Employee{

    private String name = "Senior Developer";
    public void getStatus(String task) {
        if (task.isEmpty()){
            System.out.println(this.name + " is Waiting for Assignment");
        }else {
            this.task = task;
            System.out.println(this.name + " is Working on " + this.task + " Assignment");
        }
    }
}
