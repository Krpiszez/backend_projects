package cleancode_coffeemaker;

public class CoffeeMaker implements ICoffeeMaker{

    private Coffee coffee;
    private String sugar;
    private String milk;
    private String chocolate;
    private int quality;
    private int quantity;

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    public String getSugar() {
        return sugar;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }

    public String getMilk() {
        return milk;
    }

    public void setMilk(String milk) {
        this.milk = milk;
    }

    public String getChocolate() {
        return chocolate;
    }

    public void setChocolate(String chocolate) {
        this.chocolate = chocolate;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public Coffee brewCoffee() {
        return null;
    }

    public static class CoffeeBuilder{
        private Coffee coffee;
        private String sugar;
        private String milk;
        private String chocolate;
        private int quality;
        private int quantity;

        public CoffeeBuilder(int quality, int quantity) {
            this.quality = quality;
            this.quantity = quantity;
        }

        public CoffeeBuilder withMilk(String milk){
            this.milk = milk;
            return this;
        }
    }


}
