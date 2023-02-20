package assignment_01_17;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Employee extends Person{

    // Here i use this to have salaries in better format after increasing
    DecimalFormat df = new DecimalFormat("##.##");
    int currentYear = LocalDate.now().getYear();

    double salary;

    int yearOfStartingWork;

    public Employee(double salary, int yearOfStartingWork, String name, String nationalInsuranceNumber) {
        this.salary = salary;
        this.yearOfStartingWork = yearOfStartingWork;
        super.name = name;
        super.nationalInsuranceNumber = nationalInsuranceNumber;
    }

    public Employee() {
    }

    //TASK 2
    public void displayEmployee(List<Employee> employee){
        List<Employee> res = employee.stream().sorted(Comparator.comparing(t-> t.name)).collect(Collectors.toList());
        System.out.println("Task 2: Method Coming from Child Class");
        for (Employee p: res){
            System.out.println(p);
        }
    }

    // TASK3
    public String nameOfEmployeeNIN(List<Employee> employee, String nationalInsuranceNumber){
        System.out.print("Task 3 \nThe Name Of The Employee with NIN of: " + nationalInsuranceNumber + " ");
        for (Employee emp: employee){
            if (emp.nationalInsuranceNumber.equals(nationalInsuranceNumber)){
                return emp.name;
            }
        }
        return "";
    }

    // TASK4
    public void increaseSalary(List<Employee> employee){
        System.out.println("Task 4 \nThe Employee list before raising the salaries of more than 5 years of work.");
        for (Employee emp: employee){
            System.out.println(emp);
        }
        for (Employee emp: employee){
            if (currentYear - emp.yearOfStartingWork >=5){
                emp.salary = Double.parseDouble(df.format(emp.salary * 1.1));
            }
        }
        System.out.println("Task 4 \nThe Employee list after raising the salaries of more than 5 years of work.");
        for (Employee emp: employee){
            System.out.println(emp);;
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", yearOfStartingWork=" + yearOfStartingWork +
                ", name='" + name + '\'' +
                ", nationalInsuranceNumber='" + nationalInsuranceNumber + '\'' +
                '}';
    }
}
