package enums_strategy_dp;

public enum Operations {

    PLUS("+"){
        public double apply(double x, double y){return x+y;}
    },


    private final String symbol;

    Operations(String symbol){
        this.symbol = symbol;
    }

}
