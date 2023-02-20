package competetivecoding;
/*
    Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.
     */

public class LengthOfLastWord {

    public static void main(String[] args) {
        String str = "Java is easy, dont you think eh ?";
        System.out.println(lengthOfLastWord(str));
    }
    public static int lengthOfLastWord(String str){
        String[] arr = str.replaceAll("\\p{Punct}", "").split(" ");
        return arr[arr.length-1].length();
    }
}
