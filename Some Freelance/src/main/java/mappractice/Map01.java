package mappractice;

import java.util.*;
import java.util.stream.Collectors;

public class Map01 {

    public static void main(String[] args) {
        String queen ="We are the champions, my friends, And we'll keep on fighting till the end";
        HashMap<String, Integer> map = mapping(queen);
        TreeMap<String, Integer> sorted = new TreeMap<>(mapping(queen));
        System.out.println(map);
        System.out.println(sorted);
        System.out.println(sumOfValues(map));
        System.out.println(entry(map));
        update(map);
        System.out.println(map);
        System.out.println(entry(map));
        System.out.println(distinct(map));
        System.out.println(maxVal(map));
        System.out.println(maxVal(map));
        System.out.println(sorted.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));


        HashMap<Integer, String> languages = new HashMap<>();
        languages.put(1, "java");
        languages.put(2, "javascript");
        languages.put(3, "python");
        System.out.println(languages);
        System.out.println(upperCase(languages));
        languages.replaceAll((key, value) -> value.toUpperCase());
        System.out.println(languages);

        HashMap<Integer, Integer> numbers = new HashMap<>();
        numbers.put(5, 0);
        numbers.put(8, 1);
        numbers.put(9, 2);
        System.out.println(numbers);
        numbers.replaceAll((key, value)-> value*value);
        System.out.println(numbers);
        square(numbers);
        System.out.println(numbers);


    }
    //Q9
// Change all value to uppercase
// verilen hashMap'teki tüm karakterleri BÜYÜK HARFE çevirin
    public static List<String> upperCase(HashMap<Integer, String> languages){

        Collection<String> a = languages.values();
        List<String> b = a.stream().collect(Collectors.toList());
        ListIterator<String> myItr = b.listIterator();
        while (myItr.hasNext()){
        String next = myItr.next();
        myItr.set(next.toUpperCase());
        }
        return b;
    }
        // Q10
    // replace all value with the square of key
    public static HashMap<Integer, Integer> square(HashMap<Integer, Integer> map){
        map.replaceAll((key, value) -> key*key);
        return map;
    }



        /* Q1
    count the number of characters in the given String and print HashMap and sort alphabetical order
     */

    public static HashMap<String, Integer> mapping(String str){

        String arr[] = str.replaceAll("\\p{Punct}", "").replaceAll(" ", "").toLowerCase().split("");
        HashMap<String, Integer> map = new HashMap<>();
        for (String w: arr){
            Integer numOfOcc = map.get(w);

            if (numOfOcc == null){
                map.put(w, 1);
            }else {
                map.put(w, numOfOcc+1);
            }
        }
        return map;
    }


    // Q2 type a method to find sum of values in hashmap
    public static int sumOfValues(HashMap<String, Integer> map){
        int sum = 0;
        Collection<Integer> a = map.values();
        for (Integer w: a){
            sum+=w;
        }
        return sum;
    }

    // Q3 find numbers entries
    public static Integer entry(HashMap<String, Integer> map){
        return map.values().size();
    }

    // Q4 update value of "q" key to "1977"
    public static void update(HashMap<String, Integer> map){
        map.put("q", 1977);
    }

    // Q5 find numbers entries

    // Q6 find the all distinct letters in string
    public static List<String> distinct(HashMap<String, Integer> map){
        List<String> list = new ArrayList<>();
        for (String w: map.keySet()){
            if (map.get(w) == 1){
                list.add(w);
            }
        }
        return list;
    }

    //Q7 sort the letters in descending order

    //Q8 find entry which has the maximum value
    public static String maxVal(HashMap<String, Integer> map){
        int max = Integer.MIN_VALUE;
        String str = "";
        for (Integer w: map.values()){
            max = Math.max(max, w);
        }
        for (String w: map.keySet()){
            if (map.get(w) == max){
                str = w;
            }
        }
        return str;
    }
}
