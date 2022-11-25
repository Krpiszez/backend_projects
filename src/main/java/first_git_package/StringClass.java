package first_git_package;

import java.util.Scanner;

public class StringClass {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the text");
        String text = in.nextLine();
        System.out.println("Enter the character");
        char letter = in.next().charAt(0);
        System.out.println("firstOcc) = " + firstOcc(text, letter));
    }
    /*
    1. Write a Java program to find first occurrence of a character in a string entered by user.
     User should also enter the character that is going to be searched for (3 points)
     */
    public static int firstOcc(String text, char letter){
        int res = text.indexOf(letter);
        return res+1; // we return +1 because it will give us the index

    }

}
