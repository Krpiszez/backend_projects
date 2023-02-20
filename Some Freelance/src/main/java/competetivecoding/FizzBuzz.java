package competetivecoding;
/*
        Given an integer n, return a string array answer (1-indexed) where:

        answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
        answer[i] == "Fizz" if i is divisible by 3.
        answer[i] == "Buzz" if i is divisible by 5.
        answer[i] == i (as a string) if none of the above conditions are true.
 */

import java.util.Scanner;

public class FizzBuzz {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        System.out.println(fizzBuzz(num));
    }
    public static String fizzBuzz(int a){
        String res = "";
        if (a % 3 == 0 && a % 5 != 0){
            res = "Fizz";
        } else if (a % 5 == 0 && a % 3 != 0) {
            res = "Buzz";
        } else if (a % 3 ==0 && a % 5 == 0) {
            res = "Fizz Buzz";
        }else {
            res = String.valueOf(a);
        }
        return res;
    }



}
