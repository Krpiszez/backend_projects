package creationalDP.factoryDP;

public class FactoryPatternDemo {
    public static void main(String[] args) {
        Shape circle1 = new Circle();
        circle1.draw();
        Shape square1 = new Square();
        square1.draw();
        Shape rectangle1 = new Rectangle();
        rectangle1.draw();
        System.out.println("********* SHAPE FACTORY **********");
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape1 = shapeFactory.getShape("rectangle");//"dikdortgen"
        Shape shape2 = shapeFactory.getShape("circle");
        Shape shape3 = shapeFactory.getShape("square");
        shape1.draw();
        shape2.draw();
        shape3.draw();
    }
}
