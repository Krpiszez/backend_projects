package class_hierarchy;

public class Rectangle extends FigureTrue{

    private final double width;

    private final double length;

    Rectangle(double width, double length){
        this.width = width;
        this.length = length;
    }

    @Override
    double area() {
        return width * length;
    }
}
