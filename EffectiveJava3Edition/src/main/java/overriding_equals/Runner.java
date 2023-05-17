package overriding_equals;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Try t1 = new Try(1,2);
        Try t2 = new Try(1,2);
        TryOverride to1 = new TryOverride(3,4);
        TryOverride to2 = new TryOverride(3,4);
        System.out.println(t1.equals(t2)); // here equals is not overriden so just checks its hashcode
        System.out.println(to1.equals(to2)); // equals method overriden in class so returns true

        List<Try> listT = new ArrayList<>(List.of(t1,t2, new Try(1,2)));
        List<TryOverride> listTO = new ArrayList<>(List.of(to1,to2, new TryOverride(3,4)));

        System.out.println(listT.contains(t1)); // true
        System.out.println(listT.contains(new Try(1,2))); // false
        System.out.println("listTO.contains(to2) = " + listTO.contains(to2)); // true
        System.out.println("listTO.contains(new) = " + listTO.contains(new TryOverride(3,4))); // true
    }
}
