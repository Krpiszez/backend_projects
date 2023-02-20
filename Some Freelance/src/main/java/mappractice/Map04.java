package mappractice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Map04 {
    public static void main(String[] args) {
        // Question 3: There is a Map which contains product names as key and number of the products as value.
// Print the product names in alphabetical order.(Without using TreeMap and TreeSet)
        Map<String, Integer> product = new HashMap<>();
        product.put("Olive", 25);
        product.put("Sugar", 38);
        product.put("Milk", 58);
        product.put("Egg", 17);
        product.put("Honey", 30);
        solution(product);

    }

    public static void solution (Map<String, Integer> product){
        Set<String> a = product.keySet();
        List<String> b = a.stream().sorted().collect(Collectors.toList());
        System.out.println(b);
    }
}
