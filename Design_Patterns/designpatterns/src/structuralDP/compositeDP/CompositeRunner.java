package structuralDP.compositeDP;

import java.util.Arrays;

public class CompositeRunner {

    public static void main(String[] args) {

        compositeDemo();

    }

    public static void compositeDemo(){
        Department finance = new Finance();
        Department sales = new Sales();
        Department rnd = new RnD();
        Department hr = new HRDepartment(Arrays.asList(finance, sales, rnd)); // any object implements parent interface will be added here.


        System.out.println("finance.getEmployee() = " + finance.getEmployee());
        System.out.println("finance.getName() = " + finance.getName());
        System.out.println("**************");
        System.out.println("sales.getEmployee() = " + sales.getEmployee());
        System.out.println("sales.getName() = " + sales.getName());
        System.out.println("**************");
        System.out.println("hr.getEmployee() = " + hr.getEmployee());
        System.out.println("hr.getName() = " + hr.getName());


    }
}
