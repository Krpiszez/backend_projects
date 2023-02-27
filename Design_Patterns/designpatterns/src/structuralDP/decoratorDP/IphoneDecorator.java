package structuralDP.decoratorDP;

public class IphoneDecorator implements Phone{ // Here we extend from the base class and it's the first step of our DecorationDP. This is like
    // a bridge between our improved classes. Here we have an object from our basic class which we build upon our new features by simply adding
    // to our basic class fields(attributes). Now we have those values we have set from basic class object as our base values. This class will remain
    // same, so we can use it as our new base for updated products.

    protected Phone basicPhone; // we use interface as data type because we cant depend on a class. Interface remains same.

    public IphoneDecorator(Iphone basicPhone) {
        this.basicPhone = basicPhone;
    }

    @Override
    public String getName() {
        return basicPhone.getName();
    }

    @Override
    public int cameraCount() {
        return basicPhone.cameraCount();
    }

    @Override
    public double getPrice() {
        return basicPhone.getPrice();
    }
}
