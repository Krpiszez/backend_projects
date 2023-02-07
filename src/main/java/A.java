import Assignment_12_07.SumBetweenTwoNum;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.stream.IntStream;

public class A {

    int r;

    A(int r){
        this.r = r;
    }

    public static void a(int a){
        a = a*a;
    }

    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.of(2020,12,10,1,1,1);
        int b = 5;
        a(b);
        System.out.println(b);

    }
}
