package assignment_01_17;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Employee emp1 = new Employee(12500.5, 2020, "Tom Hanks", "12345678");
        Employee emp2 = new Employee(17000.5, 2015, "Angelina Jolie", "23456789");
        Employee emp3 = new Employee(8700.5, 2021, "Brad Pitt", "34567890");
        Employee emp4 = new Employee(12000.5, 2016, "Lukasz Lewandowski", "45678901");
        Person person1 = new Person("James Bond", "56789012");
        Person person2 = new Person("Tom Cruise", "67890123");
        Person person3 = new Person("Marilyn Monroe", "78901234");

        List<Person> listOfPeople = new ArrayList<>();
        listOfPeople.add(emp1);
        listOfPeople.add(emp2);
        listOfPeople.add(emp3);
        listOfPeople.add(emp4);
        listOfPeople.add(person1);
        listOfPeople.add(person2);
        listOfPeople.add(person3);

        List<Employee> listOfEmployee = new ArrayList<>();
        listOfEmployee.add(emp1);
        listOfEmployee.add(emp2);
        listOfEmployee.add(emp3);
        listOfEmployee.add(emp4);
        //listOfEmployee.add(person1); // here i wanted to show this object is a person class object so cant be added to an
        //employee list


        new Person().displayPeople(listOfPeople);
        new Employee().displayEmployee(listOfEmployee);
        System.out.println(new Employee().nameOfEmployeeNIN(listOfEmployee, "45678901"));
        new Employee().increaseSalary(listOfEmployee);
        System.out.println();
    }
}
