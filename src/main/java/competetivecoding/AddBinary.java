package competetivecoding;

public class AddBinary {
    /*
    Given two binary strings a and b, return their sum as a binary string.
     */
    public static void main(String[] args) {

        System.out.println(addBinary("1101", "1"));

    }
    public static String addBinary(String a, String b){
        int sum =0;
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1;
        int k = b.length()-1;
        while (i>=0 || k>=0){
            if (i>=0) sum+=a.charAt(i)-'0';
            if (k>=0) sum+=b.charAt(k)-'0';
            sb.append(sum%2);
            sum/=2;
            i--;
            k--;
        }if (sum != 0){
            sb.append(sum);
        }
        return sb.reverse().toString();
    }
}
