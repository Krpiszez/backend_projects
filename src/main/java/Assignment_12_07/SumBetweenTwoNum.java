package Assignment_12_07;

import java.util.stream.IntStream;

public class SumBetweenTwoNum {

    public static void main(String[] args) {

        System.out.println(new SumBetweenTwoNum().SumBetweenTwoNum(2, 4));

    }


    public int SumBetweenTwoNum(int m, int n){

        return IntStream.rangeClosed(m,n).sum();

    }

}
