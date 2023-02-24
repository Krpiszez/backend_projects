package structuralDP.proxyDP;

public class ProxyRunner {

    public static void main(String[] args) {

        ImageGenerator proxyClass1 = new ImageProxyClass("c:\\image1.png");
        ImageGenerator proxyClass2 = new ImageProxyClass("c:\\image2.png");

        proxyClass1.showImageName();
        proxyClass2.showImageName();

    }
}
