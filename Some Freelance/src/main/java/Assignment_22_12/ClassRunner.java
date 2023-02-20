package Assignment_22_12;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClassRunner {

    public static void main(String[] args) {
        Class std1 = new Class("Tom", "Hanks", 19, 4, "Math", 20220001);
        Class std2 = new Class("Brad", "Pitt", 20, 4, "P.E", 20220002);
        Class std3 = new Class("Angelina", "Jolie", 19, 5, "Science", 20220003);
        Class std4 = new Class("Tom", "Sawyer", 21, 2, "Math", 20220004);
        Class std5 = new Class("Tom", "Cruise", 22, 1, "Math", 20220005);
        Class std6 = new Class("Patrik", "Schneider", 19, 3, "Geography", 20220006);
        Class std7 = new Class("Lukasz", "Mukasz", 18, 5, "Science", 20220007);
        Class std8 = new Class("Sam", "Wise", 19, 1, "Geography", 20220008);
        Class std9 = new Class("Nelly", "Treeson", 18, 2, "P.E", 20220009);
        Class std10 = new Class("Ela", "Tomaszchuk", 21, 3, "Geography", 20220010);
        List<Class> classOf2020 = new ArrayList<>();
        classOf2020.add(std1);
        classOf2020.add(std2);
        classOf2020.add(std3);
        classOf2020.add(std4);
        classOf2020.add(std5);
        classOf2020.add(std6);
        classOf2020.add(std7);
        classOf2020.add(std8);
        classOf2020.add(std9);
        classOf2020.add(std10);
        display(classOf2020);
        System.out.println("================");
        displayStudentsYoungerThan20(classOf2020);
        System.out.println("================");
        displayStudentsOnAlphOrder(classOf2020);
    }

    public static void display(List<Class> cls){ // Task 1.
        System.out.println("List of all students:");
        for (Class w: cls){
            System.out.println(w);
        }
    }

    public static void displayStudentsYoungerThan20 (List<Class> cls){ // Task 2.
        System.out.println("Students who younger than 20 y.o: ");
        for (Class w: cls){
            if (w.getAge() < 20){
                System.out.println(w);
            }
        }
    }

    public static void displayStudentsOnAlphOrder(List<Class> cls){ // Task 3.
        System.out.println("Students sorted in natural order on their names: ");
        cls.stream().sorted(Comparator.comparing(Class::getName)).forEach(System.out::println);
    }

}
