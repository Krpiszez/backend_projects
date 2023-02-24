package structuralDP.decoratorDP;

public class Iphone11 extends IphoneDecorator{

    public Iphone11(Iphone basicPhone) {
        super(basicPhone);
    }

    @Override
    public String getName() {
        return super.getName() + " 11";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 100;
    }

}
