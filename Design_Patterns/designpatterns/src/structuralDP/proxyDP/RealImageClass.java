package structuralDP.proxyDP;

public class RealImageClass implements ImageGenerator{

    private String fullPath;

    public RealImageClass(String fullPath) {
        this.fullPath = fullPath;
    }

    @Override
    public void showImageName() {
        System.out.println("Image name displayed... " + fullPath);
    }

    public void changeImage(){
        // many lines of code to change image
    }

    public void changeImageFormat(){
        // many lines of code to change image format...
    }

    public void loadImage(){
        // methods to load image
    }
}
