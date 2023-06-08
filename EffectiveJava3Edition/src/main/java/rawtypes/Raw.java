package rawtypes;

import java.util.ArrayList;
import java.util.List;

public class Raw {

    static List<String> names = new ArrayList<>();


    private static void addItems(List list, Object o){
        list.add(o);
    }

    public static void main(String[] args) {
        addItems(names, "Omer");
        addItems(names, 42);
        System.out.println(names);
        System.out.println("names.get(0) = " + names.get(0));
        System.out.println("names.get(1) = " + names.get(1));
        // Here it was able to add an Integer value to a String list but couldn't use .get method because Casting was necessary,
        //and it didn't give any compile time error so the exception is thrown without being handled.
    }
}
