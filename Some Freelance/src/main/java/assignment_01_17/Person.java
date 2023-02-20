package assignment_01_17;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Person {

    String name;

    String nationalInsuranceNumber;

    public Person() {
    }

    public Person(String name, String nationalInsuranceNumber) {
        this.name = name;
        this.nationalInsuranceNumber = nationalInsuranceNumber;
    }

    //TASK1
    public void displayPeople(List<Person> person){ // Here i type the method in the parent class and the parameter with
        // parent data type so all classes derived from this class can implement this method and use their own class name
        // as data type to inject into this method.
        List<Person> res = person.stream().sorted(Comparator.comparing(t-> t.name)).collect(Collectors.toList());
        System.out.println("Task 1: Method Coming from Parent Class");
        for (Person p: res){
            System.out.println(p);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", nationalInsuranceNumber='" + nationalInsuranceNumber + '\'' +
                '}';
    }
}
