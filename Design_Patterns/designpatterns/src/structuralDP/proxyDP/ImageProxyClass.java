package structuralDP.proxyDP;

public class ImageProxyClass implements ImageGenerator{

    private RealImageClass realImageClass;

    private String fullPath;

    public ImageProxyClass(String fullPath) {
        this.fullPath = fullPath;
    }

    @Override
    public void showImageName() {
        // since we will not create an instance from real class
        // instance will be created.
        if (realImageClass==null){
            realImageClass = new RealImageClass(fullPath);
            realImageClass.showImageName();
        }

    }
}
