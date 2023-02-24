package structuralDP.proxyDP;

public interface ImageGenerator { // here when we have a class which has many methods to work on, but we need to use just specific method or methods
    // from this class, and we want to keep other methods out of sight then we can simply use a proxy class to use just needed method in it as it's
    // a shadow of the real class we have.

    void showImageName();
}
