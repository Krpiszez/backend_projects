package structuralDP.decoratorDP;

public class DecoratorRunner {

    public static void main(String[] args) {

        Phone iPhone11ProMax = new Iphone11ProMax(new Iphone());
        System.out.println("iPhone11ProMax = " + iPhone11ProMax.getName());
        System.out.println("iPhone11ProMax.cameraCount() = " + iPhone11ProMax.cameraCount());
        System.out.println("iPhone11ProMax.getPrice() = " + iPhone11ProMax.getPrice());
        System.out.println("*****************");
        Phone iPhone11Pro = new Iphone11Pro(new Iphone());
        System.out.println("iPhone11Pro = " + iPhone11Pro.getName());
        System.out.println("iPhone11Pro.cameraCount() = " + iPhone11Pro.cameraCount());
        System.out.println("iPhone11Pro.getPrice() = " + iPhone11Pro.getPrice());
        System.out.println("*****************");
        Phone iPhone11 = new Iphone11(new Iphone());
        System.out.println("iPhone11 = " + iPhone11.getName());
        System.out.println("iPhone11.cameraCount() = " + iPhone11.cameraCount());
        System.out.println("iPhone11.getPrice() = " + iPhone11.getPrice());

    }
}
