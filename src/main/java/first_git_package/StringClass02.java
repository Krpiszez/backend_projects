package first_git_package;

import java.util.Scanner;

public class StringClass02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the text");
        String text = in.nextLine();
        System.out.println("The answer is = " + tripleChars(text));
    }
    /*
    2. Write a Java program to create a new string repeating every character three times of a string
     entered by user (3 points)
        Example:
        Input: Lab_Six
        Output: LLLaaabbb___SSSiiixxx

     */
    public static String tripleChars(String text){
        String res = "";
        int repetition = 3;
        for (int i =0; i<text.length(); i++){
            for (int k =0; k<repetition; k++){
                res+=text.charAt(i);
            }
        }
        return res;
    }

}
