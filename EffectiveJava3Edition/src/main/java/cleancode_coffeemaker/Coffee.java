package cleancode_coffeemaker;

public class Coffee {

    private String quality;
    private int amount;

    public Coffee(String quality, int amount) {
        this.quality = quality;
        this.amount = amount;
    }

    public Coffee() {
    }

    public static class Builder{

        private String quality;
        private int amount;

        public Builder twoCups(){
            this.amount = 2;
            return this;
        }
    }

    public Coffee(Builder builder){
        this.quality = builder.quality;
        this.amount = builder.amount;
    }
}
