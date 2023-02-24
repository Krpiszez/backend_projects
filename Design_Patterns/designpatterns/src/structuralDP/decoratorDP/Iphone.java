package structuralDP.decoratorDP;

public class Iphone implements Phone{ // This is the basic class which we start our DecoratorDP from
    @Override
    public String getName() {
        return "Iphone";
    }

    @Override
    public int cameraCount() {
        return 2;
    }

    @Override
    public double getPrice() {
        return 559.9;
    }
}
