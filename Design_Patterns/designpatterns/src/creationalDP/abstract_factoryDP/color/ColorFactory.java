package creationalDP.abstract_factoryDP.color;

import creationalDP.abstract_factoryDP.AbstractFactory;
import creationalDP.abstract_factoryDP.shape.Shape;

public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        if(color==null){
            return null;
        }
        if(color.equalsIgnoreCase("RED")){
            return new Red();
        } else if(color.equalsIgnoreCase("BLUE")){
            return new Blue();
        }else if(color.equalsIgnoreCase("GREEN")){
            return new Green();
        }
        return null;
    }

    @Override
    public Shape getShape(String shapeType) {
        return null;
    }
}
