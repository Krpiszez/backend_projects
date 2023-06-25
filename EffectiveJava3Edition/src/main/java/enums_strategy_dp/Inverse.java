package enums_strategy_dp;

public class Inverse {
    public static Operation inverse(Operation op){
        switch (op){
            case MINUS: return Operation.PLUS;
            case PLUS: return Operation.MINUS;
            case TIMES: return Operation.DIVIDE;
            case DIVIDE: return Operation.TIMES;
            default: throw  new AssertionError("Unknown op: " + op);
        }
    }

    public static void main(String[] args) {
        double x = 5;
        double y = 4;
        for (Operation o: Operation.values()){
            Operation invOp = inverse(o);
            System.out.printf("%f %s %f %s %f = %f%n", x, o, y, invOp, y, invOp.apply(o.apply(x, y), y));
        }

        //  Derleme anında değerlerini bildiğiniz bir grup değişmeze ne zaman ihtiyaç duyarsanız enum kullanın
        //  Whenever you need a group of constant that you know the values in compile time, use ENUMS
        /*
         * Her enum sabiti için farklı davranışlar belirlemeniz gereken durumlarda switch deyimi ile farklı davranışları kodlamak yerine
         * enum içinde soyut bir metot tanımlayıp her enum sabiti için bu metodu geçersiz kılın.
         * Eğer bazı enum sabitlerinin davranışları birbiriyle aynı ise strateji enum desenini uygulayın.
         * Instead of using switch statement for every single constant create an abstract method and override it for each case.
         * If some enum constants have similar behaviours then use Strategy Pattern.
         */
    }
}
