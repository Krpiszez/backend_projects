package structuralDP.decoratorDP;

public interface Phone { // Here for DecoratorDP think about a product that is released every year with some slight improvements
    // and new features. For productions like that this DP can be used because only few new things will be added, most features
    // are remain same even it is not same it just changes on their values.

    String getName();

    int cameraCount();

    double getPrice();

}
