package mappractice;

import java.util.*;

public class Map05 {
    public static void main(String[] args) {

        // Question 4: Print the prices in ascending order.
        Map<String, Integer> product = new HashMap<>();
        product.put("Olive", 25);
        product.put("Sugar", 38);
        product.put("Milk", 58);
        product.put("Egg", 17);
        product.put("Honey", 30);
        prices(product);
        List<String> elements = new ArrayList<>();
        elements.add("Gold");
        elements.add("Silver");
        elements.add("Uranyum");
        elements.add("Iron");
        iterator(elements);
// Question 5: Update every element by putting "*" to end. By using iterators.
    }
    public static void prices(Map<String, Integer> products){
        Collection<Integer> a = products.values();
        a.stream().sorted().forEach(System.out::println);
    }
    public static void iterator(List<String> elements){
        ListIterator<String> myItr = elements.listIterator();
        while(myItr.hasNext()){
            String a = myItr.next();
            myItr.set(a + "*");
        }
        System.out.println(elements);
    }
}
