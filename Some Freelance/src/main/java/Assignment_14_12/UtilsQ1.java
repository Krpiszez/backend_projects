package Assignment_14_12;

public class UtilsQ1 {

    public static boolean checkEvenNumber(final int num) {
        return num % 2 == 0;
    }

    public static boolean checkOddNumber(final int num) {
        return num % 2 != 0;
    }

    public static boolean checkPrimeNumber(final int num) {
        if (num == 0 || num == 1) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkPalindrome(final String word) {
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
