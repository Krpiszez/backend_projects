package structuralDP.decoratorDP;

public class IphoneDecorator implements Phone{

    protected Phone basicPhone;

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
