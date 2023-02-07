package assignment_02_07;


import java.util.Map;
import java.util.Scanner;

public class ScheduleRunner {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the day you want to work on!");
        String dayName = scan.next();
        Day day = null;
        if (dayName.equalsIgnoreCase("monday")){
            day = new Monday();
        } else if (dayName.equalsIgnoreCase("tuesday")) {
            day = new Tuesday();
        } else if (dayName.equalsIgnoreCase("wednesday")) {
            day = new Wednesday();
        }

        day.getDay();


    }

}
