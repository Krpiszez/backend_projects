package structuralDP.decoratorDP;

public class Iphone11 extends IphoneDecorator{ // here by adding similar updates we are getting improved features for our next product.
    // We dont need to override the methods for values which we are not going to update.

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
