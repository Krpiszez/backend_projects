package enums_strategy_dp;

public class PlanetRun {

    public static void main(String[] args) {
        double earthWeight = 15;
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        for (Planet pl: Planet.values()){
            System.out.printf("Weight on %s is %f%n", pl, pl.surfaceWeight(mass));
        }
    }
}
