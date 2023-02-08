package assignment_02_07;

public class TriangleRunner {

    public static void main(String[] args) {
        MyTriangle myTriangle = new MyTriangle(5,12,13);
        System.out.println(myTriangle.canBuilt());
        System.out.println(myTriangle.calculateArea(myTriangle));
    }

}
