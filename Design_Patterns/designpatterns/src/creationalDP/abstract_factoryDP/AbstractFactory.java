package creationalDP.abstract_factoryDP;

import creationalDP.abstract_factoryDP.color.Color;
import creationalDP.abstract_factoryDP.shape.Shape;

public abstract class AbstractFactory { // here we need this dp if we have more than one specification that is gonna extend to
    // our factory class to create objects. In out example a shape also has a color which may differ.

    public abstract Color getColor(String colorType);

    public abstract Shape getShape(String shapeType);

}
