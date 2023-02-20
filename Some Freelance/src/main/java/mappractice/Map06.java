package mappractice;

import java.util.HashMap;
import java.util.Scanner;

public class Map06 {
    public static void main(String[] args) {
        // Question 6: Get two String from user and create a function to be able to find this Strings are anagram or not?
// For example: RAKI and IRAK are anagram
        System.out.println("anagram() = " + anagram());
        System.out.println("isAnagram() = " + isAnagram("SASA", "SAAA"));


    }

    public static boolean anagram(){
        boolean res = true;
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        HashMap<String, Integer> map = new HashMap<>();
        if (a.length()!=b.length()){
            return false;
        }else {
            for (int i =0; i<a.length(); i++){
                String c = a.substring(i, i+1);
                if (!map.containsKey(c)){
                    map.put(c, 1);
                }else {
                    map.put(c, map.get(c)+1);
                }
            }
            for (int i =0; i<b.length(); i++){
                String c = b.substring(i, i+1);
                if (map.containsKey(c)){
                    map.put(c, map.get(c)-1);
                    if (map.get(c)==0){
                        map.remove(c);
                    }
                }
                else {
                    res = false;
                }
            }
            return res;
        }
    }
    public static boolean isAnagram(String s, String t){
        if (s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (hm.containsKey(c)){
                hm.put(c,hm.get(c) + 1);
            }else {
                hm.put(c,1);
            }
        }
        for (int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            if (hm.containsKey(c)){
                hm.put(c,hm.get(c)-1);
                if (hm.get(c) == 0){
                    hm.remove(c);
                }
            }else {
                return false;
            }
        }
        return true;
    }
}
