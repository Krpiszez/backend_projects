package first_git_package;

import java.util.Arrays;
import java.util.Scanner;

public class StringClass05 {
    public static void main(String[] args) {
        System.out.println("After converting your array is = " + Arrays.deepToString(rowToColumn()));

    }
    /*
            5. Write the Java program that transforms rows into columns in two-dimensional array.
             Array has to be initialised by the user (3 points)
        Example:
        Input:
        1 2 3 4
        5 6 7 8
        Output:
        1 5
        2 6
        3 7
        4 8

*/
    public static int[][] rowToColumn(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the num of rows");
        int rows = in.nextInt();
        System.out.println("Enter the num of columns");
        int columns = in.nextInt();
        int arr[][] = new int[rows][columns];
        for (int i=0; i<rows; i++){
            for (int k =0; k<columns; k++){
                System.out.println("Enter numbers");
                arr[i][k] = in.nextInt();
            }
        }
        System.out.println("Your two dimensional array is : " + Arrays.deepToString(arr));

        int brr[][] = new int[columns][rows];
        for (int i =0; i< columns; i++){
            for (int k=0; k<rows; k++){
                brr[i][k] = arr[k][i];
            }
        }
        System.out.println("New Array may look like =");
        for (int i =0; i<columns; i++){

            System.out.println(Arrays.toString(brr[i]));
        }
        return brr;
    }

}
