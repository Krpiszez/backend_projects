package first_git_package;

import java.util.Scanner;

public class StringClass04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the text");
        String text = in.nextLine();
        System.out.println("Enter the chars you want to change");
        String setOfChars = in.next();
        System.out.println("Enter new values");
        String newVal = in.next();
        System.out.println("Updated text is = " + change2Characters(text, setOfChars, newVal));

    }
    /*
    4. Write a Java program to search for specific set of 2 characters
     in a string entered by user and change it for any other value requested by user (3 points)
*/
    public static String change2Characters(String text, String setOfChars, String newVal){
        text = text.replaceFirst(setOfChars, newVal);
        return text;
    }

}
