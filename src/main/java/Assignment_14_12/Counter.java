package Assignment_14_12;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class Counter {

    public static void main(String[] args) {

        List<Integer> count = Arrays.asList(1, 2, 3,84, 4, 5, 6,96);
        System.out.println(countIf(count, UtilsQ1::checkEvenNumber));
        Integer[] array = {1,2,3,4};
        swap(array,1,2);
        System.out.println(Arrays.toString(array));
        System.out.println(maximalElement(count, 0, count.size()));


    }
    /*
    1. Write a generic method to count the number of elements in a collection
     that have a specific property (e.g., odd integers, prime numbers, palindromes) (3 points)
     */
    public static <T> long countIf(Collection<T> collection, Predicate<T> predicate) {
        return collection.stream()
                .filter(predicate)
                .count();
    }

    public static <T> void swap (T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static <T extends Comparable> T maximalElement (List<T> list, int from, int to) {
        T maximal = list.get(from);
        for (int i = from + 1; i < to; i++) {
            T elem1 = list.get(i);
            if (elem1.compareTo(maximal) > 0) {
                maximal = elem1;
            }
        }
        return maximal;
    }
}
