package Assignment_14_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListManipulations {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        List<Integer> a = Arrays.asList(1,2,3);
        addEl(list, 1,43,24,56,87,21);
        removeEl(list,43,87);
        System.out.println(list);
        swapEl(list,0,1);
        System.out.println(list);
        numberOfEl(list);
        minAndMax(list);
        System.out.println("isExist = " + isExist(list, 56));
        printList(list);
        System.out.println();
        joinList(list,a);
        System.out.println(list);

    }

    public static void addEl(List<Integer> list, int... a){
        for (int w: a){
            list.add(w);
        }
    }
    public static void removeEl(List<Integer> list, int... a){
        for (int w: a){
            list.remove((Integer)w);
        }
    }
    public static void swapEl(List<Integer> list, int a, int b){
        int x = list.get(a);
        int y = list.get(b);
        list.set(a, y);
        list.set(b, x);
    }
    public static void numberOfEl(List<Integer> list){

        System.out.println(list.size());

    }
    public static void minAndMax(List<Integer> list){
        int min = list.get(0);
        int max = list.get(0);
        for (int w: list){
            min = Math.min(min, w);
            max = Math.max(max,w);
        }
        System.out.println("min = " + min);
        System.out.println("max = " + max);
    }
    public static boolean isExist(List<Integer> list, int a){
        return list.contains(a);
    }
    public static void printList(List<Integer> list){
        list.stream().forEach(t-> System.out.print(t + " "));
    }
    public static void joinList(List<Integer> list, List<Integer> a){
        list.addAll(a);
    }

}
