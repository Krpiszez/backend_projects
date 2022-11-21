package mappractice;

import java.util.HashMap;

public class Map03 {

    public static void main(String[] args) {
        // Question 2: Write a program to be able to find intersection of two array by using HashMap.
        int arr[] = {2, 4, 6, 10, 12, 14, 20};
        int brr[] = {3, 5, 7, 8, 9, 10, 14, 15, 16};

        intersection(arr, brr);


    }

    public static void intersection(int[] arr, int[] brr) {

        HashMap<Integer, Integer> mapArr = new HashMap<>();
        for (Integer w : arr) {
            Integer occ = mapArr.get(w);
            if (occ == null) {
                mapArr.put(w, 1);
            } else {
                mapArr.put(w, occ + 1);
            }
        }
        for (Integer w : brr) {
            if (!mapArr.containsKey(w)) {
                mapArr.remove(w);
            }
        }
        System.out.println(mapArr);
    }

    public static void getIntersection(int a[], int b[]) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int w : a) {
            if (hm.containsKey(w)) {
                hm.put(w, hm.get(w) + 1);
            } else {
                hm.put(w, 1);
            }
        }
        for (int w : b) {
            if (hm.containsKey(w)) {
                System.out.print(w + " ");
            }
        }
    }
}
