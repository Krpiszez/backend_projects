package first_git_package;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Arrays01 {
    public static void main(String[] args) {
        int arr[] = {1,2,3,8,5,6};
        largestArrayElement(arr);
        smallestArrayElement(arr);
//        evenAndOddElements();
//        positiveNegativeElementsOfArray();
        evenAndOddIndices();


    }

    /*
    1. Write Java program to find the largest and the smallest element in the array.
     The program has to give the user the indices of these elements.
     */
    public static void largestArrayElement(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i =0; i<arr.length; i++){
            max = Math.max(arr[i], max);
        }
        for (int i =0; i<arr.length; i++){
            if(arr[i] == max){
                System.out.println("Index of largest array element is: " + i);
            }
        }
    }
    public static void smallestArrayElement(int[] arr){
        int min = Integer.MAX_VALUE;
        for (int i =0; i<arr.length; i++){
            min = Math.min(arr[i], min);
        }
        for (int i =0; i<arr.length; i++){
            if(arr[i] == min){
                System.out.println("Index of smallest array element is: " + i);
            }
        }
    }
    /*
    2. Write the Java program that accepts the elements from the user input and writes even values
     into one array and odd into the another array. Display the result on the console.
     */

    public static void evenAndOddElements(){
        Scanner in = new Scanner(System.in);
        System.out.println("What is the amount of numbers you will enter?");
        int amount = in.nextInt();
        int even[] = new int[amount];
        int odd[] = new int[amount];
        int oddidx = 0;
        int evenidx = 0;
        for (int i =0; i<amount; i++){
            System.out.println("Enter number");
            int num = in.nextInt();
            if (num % 2 ==0){
                even[evenidx] = num;
                evenidx++;
            } else  {
                odd[oddidx] = num;
                oddidx++;
            }
        }
        System.out.println("Even numbers you entered are: " + Arrays.toString(even));
        System.out.println("Odd numbers you entered are: " + Arrays.toString(odd));
    }
    /*
    3. Write the Java program to count numbers of positive and negative
     elements in the array. Array has to be initialised by the user.
     */
    public static void positiveNegativeElementsOfArray(){
        Scanner in = new Scanner(System.in);
        System.out.println("What is the amount of numbers you will enter?");
        int amount = in.nextInt();
        int arr[] = new int[amount];
        int posCounter = 0;
        int negCounter = 0;
        for (int i =0; i<amount; i++){
            System.out.println("Enter Number");
            arr[i] = in.nextInt();
        }
        for (int i = 0; i<arr.length; i++){
            if (arr[i] >= 0){
                posCounter++;
            }else {
                negCounter++;
            }
        }
        System.out.println("There are " + posCounter + " positive elements in your array.");
        System.out.println("There are " + negCounter + " negative elements in your array.");
    }
    /*
    4. Write the Java program that would display separately elements with the odd
     indices and elements with the even indices. Array has to be initialised by the user.
     */
    public static void evenAndOddIndices(){
        Scanner in = new Scanner(System.in);
        System.out.println("What is the amount of numbers you will enter?");
        int amount = in.nextInt();
        int arr[] = new int[amount];
        List<Integer> evenIndices = new ArrayList<>();
        List<Integer> oddIndices = new ArrayList<>();
        for (int i=0; i<amount; i++){
            System.out.println("Enter a number");
            arr[i] = in.nextInt();
        }
        System.out.println("Your array is: " + Arrays.toString(arr));
        for (int i =0; i<arr.length; i++){
            if (i%2==0){
                evenIndices.add(arr[i]);
            }else {
                oddIndices.add(arr[i]);
            }
        }
        System.out.println("Elements in even indices are: " + evenIndices);
        System.out.println("Elements in odd indices are: " + oddIndices);
    }
}
