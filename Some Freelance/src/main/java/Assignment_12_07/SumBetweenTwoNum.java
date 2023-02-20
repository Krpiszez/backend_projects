package Assignment_12_07;

import java.util.Scanner;
import java.util.stream.IntStream;

public class SumBetweenTwoNum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 2 value to get the sum the numbers between them");
        int m = in.nextInt();
        int n = in.nextInt();
        System.out.println(new SumBetweenTwoNum().SumBetweenTwoNum(m, n));

    }


    public int SumBetweenTwoNum(int m, int n){

        if (m>n){
            m=m+n;
            n=m-n;
            m=m-n;
        }
        return IntStream.rangeClosed(m,n).sum();
    }

}
