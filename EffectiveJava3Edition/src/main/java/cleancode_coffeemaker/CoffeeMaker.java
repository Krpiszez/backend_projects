package cleancode_coffeemaker;


public class CoffeeMaker implements ICoffeeMaker{

    private final BoilerPlate boilerPlate;

    public CoffeeMaker(BoilerPlate bP){
        this.boilerPlate = bP;
    }

    private int sugar;
    private boolean milk;
    private boolean chocolate;
    private int quality;
    private int quantity;

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public boolean getMilk() {
        return milk;
    }

    public void setMilk(boolean milk) {
        this.milk = milk;
    }

    public boolean getChocolate() {
        return chocolate;
    }

    public void setChocolate(boolean chocolate) {
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

    private CoffeeMaker (CoffeeMaker coffeeMaker, BoilerPlate boilerPlate){

        this.boilerPlate = boilerPlate;
    }

    @Override
    public Coffee brewCoffee(CoffeeBuilder builder) {
        return null;
    }

    public static class CoffeeBuilder{
        public int sugar;
        public boolean milk;
        public boolean chocolate;
        public int quality;
        public int quantity;

        public CoffeeBuilder(int quality, int quantity) {
            this.quality = quality;
            this.quantity = quantity;
        }

        public CoffeeBuilder withMilk(){
            this.milk = true;
            return this;
        }

        public CoffeeBuilder withChocolate(){
            this.chocolate = true;
            return this;
        }

        public CoffeeBuilder withSugar(int sugar){
            this.sugar = sugar;
            return this;
        }

        public CoffeeMaker build(){
            return new CoffeeMaker(this);
        }
    }
    public CoffeeMaker (CoffeeBuilder builder){
        sugar = builder.sugar;
        chocolate = builder.chocolate;
        milk = builder.milk;
        quality = builder.quality;
        quantity = builder.quantity;
        this.boilerPlate = new BoilerPlate();
    }

    @Override
    public String toString() {
        return "CoffeeMaker{" +
                ", sugar=" + sugar +
                ", milk=" + milk +
                ", chocolate=" + chocolate +
                ", quality=" + quality +
                ", quantity=" + quantity +
                '}';
    }
}
