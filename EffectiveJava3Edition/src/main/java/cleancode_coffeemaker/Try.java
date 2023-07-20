package cleancode_coffeemaker;

public class Try {

    public static void main(String[] args) {

        CoffeeMaker coffee = new CoffeeMaker.CoffeeBuilder(1,3).withChocolate().build();
        System.out.println(coffee.toString());

    }
}
