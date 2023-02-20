package first_git_package;

import java.util.Scanner;

public class StringClass03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the text");
        String text = in.nextLine();
        System.out.println("The answer is = " + initialsOfName(text));
    }
    /*
    3. Write a Java program that computes your initials (entered from keyboard) from your full name and displays them (3 points)
        Example:
        Input: John Smith
        Output: J.S.
*/
    public static String initialsOfName(String text){
        String res = "";
        text = text.replaceAll("[^A-Z]", "");
        for (int i =0; i<text.length(); i++){
            res+=text.charAt(i) + ".";
        }
        return res;
    }

}
