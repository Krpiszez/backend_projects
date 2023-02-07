package assignment_02_07;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestDay extends Day{

    private String name = "TestDay";
    @Override
    public Map<Integer, String> getDay() {
        Scanner scan = new Scanner(System.in);
        Map<Integer, String> schedule = new HashMap<>();
        schedule.put(1, Day.science);
        schedule.put(2, Day.math);
        schedule.put(3, Day.physicalEducation);
        System.out.println("Your " + this.name + " schedule is: " + schedule);
        System.out.println("Type yes if you want to update schedule: ");
        if (scan.next().equalsIgnoreCase("yes")){
            schedule.clear();
            System.out.println("How many classes you want for " + this.name + " ?");
            scan.nextLine();
            int num = scan.nextInt();
            scan.nextLine();
            for (int i =1; i<=num; i++){
                System.out.println("Type class name you want for todays schedule: ");
                schedule.put(i, scan.nextLine());
            }
            System.out.println("Your updated " + this.name + " schedule is: " + schedule);
        }
        return schedule;
    }
}
