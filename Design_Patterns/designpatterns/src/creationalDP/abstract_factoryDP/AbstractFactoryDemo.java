package creationalDP.abstract_factoryDP;

import creationalDP.abstract_factoryDP.color.Color;
import creationalDP.abstract_factoryDP.shape.Shape;

public class AbstractFactoryDemo {
    public static void main(String[] args) {

        AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");
        Shape shape1 = shapeFactory.getShape("circle");
        shape1.draw();

        AbstractFactory colorFactory = FactoryProducer.getFactory("color");
        Color color1 = colorFactory.getColor("Red");
        color1.fill();

    }
}
