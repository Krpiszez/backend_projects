package structuralDP.proxyDP;

public class ProxyRunner {

    public static void main(String[] args) {

        ImageGenerator proxyClass1 = new ImageProxyClass("c:\\image1.png");
        ImageGenerator proxyClass2 = new ImageProxyClass("c:\\image2.png");

        proxyClass1.showImageName();
        proxyClass2.showImageName();
        System.out.println(prime(163));

    }

    private static boolean prime(int a){
        boolean res = false;
        for (int i = 2; i<a; i++){
            if( a % i == 0){
                res = true;
                break;
            }
        }
        return res;
    }
}
