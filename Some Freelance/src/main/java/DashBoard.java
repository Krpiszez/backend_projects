import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DashBoard {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();

        for (int i =13; i<31; i++){
            int a = in.nextInt();
            map.put(i, a);
        }
        System.out.println("Gun gun dizilen tiff = " + map);
        int sum =0;
        for (Integer w: map.values()){
            sum+=w;
        }
        System.out.println("13-30 arasi total dizilen tiff = " + sum);



    }

}
