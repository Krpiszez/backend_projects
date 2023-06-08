package class_hierarchy;

public class Circle extends FigureTrue{

    private final double radius;

    Circle(double radius){
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * (radius * radius);
    }
}
