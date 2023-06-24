package enums_strategy_dp;

public enum Operation {

    PLUS("+"){
        public double apply(double x, double y){return x+y;}
    },
    MINUS("-"){
        public double apply(double x, double y){return x-y;}
    },
    TIMES("*") {
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        public double apply(double x, double y) {
            return x / y;
        }
    };

    @Override
    public String toString() {
        return "Operations{" +
                "symbol='" + symbol + '\'' +
                '}';
    }

    private final String symbol;

    Operation(String symbol){
        this.symbol = symbol;
    }

    public abstract double apply(double x, double y);

}
