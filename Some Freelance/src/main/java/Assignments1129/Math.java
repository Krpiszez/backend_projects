package Assignments1129;

import java.util.Scanner;

public class Math {
    /*
    2. Create a class named 'Math' with 3 methods for different math operations:
     for calculating the sum, average and product of three numbers entered by user.
      Result should be printed for user (3 points).
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose operation");
        System.out.println("1: Sum");
        System.out.println("2: Average");
        System.out.println("3: Multiplication");
        int option = in.nextInt();
        switch (option){
            case 1:
                System.out.println("Enter 3 numbers to do you operation");
                System.out.println("Sum of your numbers is: " + sum(in.nextInt(), in.nextInt(), in.nextInt()));
                break;
            case 2:
                System.out.println("Enter 3 numbers to do you operation");
                System.out.println("Average of your numbers is: " + average(in.nextInt(), in.nextInt(), in.nextInt()));
                break;
            case 3:
                System.out.println("Enter 3 numbers to do you operation");
                System.out.println("Product of your numbers is: " + product(in.nextInt(), in.nextInt(), in.nextInt()));
                break;
        }

    }

    public static double sum(double a, double b, double c){

        return a+b+c;

    }
    public static double average(double a, double b, double c){

        return (a+b+c)/3;

    }
    public static double product(double a, double b, double c){

        return a*b*c;

    }
}
