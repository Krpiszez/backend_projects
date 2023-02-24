package structuralDP.decoratorDP;

public class Iphone11Pro extends IphoneDecorator{
    public Iphone11Pro(Iphone basicPhone) {
        super(basicPhone);
    }

    @Override
    public String getName() {
        return super.getName() + " 11 Pro";
    }

    @Override
    public int cameraCount() {
        return super.cameraCount() + 1;
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 100;
    }
}
