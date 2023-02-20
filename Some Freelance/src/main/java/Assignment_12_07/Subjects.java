package Assignment_12_07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subjects {

    public static void main(String[] args) {
        Subjects fieldsOfStudy = new Subjects("science", "physical");
    }

    List<String> science = Arrays.asList("Math", "Physics");
    List<String> physical = Arrays.asList("Physical Education");
    public Subjects(String a, String b) {
        if (a.equalsIgnoreCase("science")&&b.equalsIgnoreCase("physical")){
            System.out.println("Fields Of Study Of P.E. is "+physical);
            System.out.println("Fields Of Study Of Science is "+science);
        }
    }
    public Subjects() {
        System.out.println("Unknown");
    }
}
