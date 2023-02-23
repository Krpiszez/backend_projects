package creationalDP.abstract_factoryDP.shape;

import creationalDP.abstract_factoryDP.AbstractFactory;
import creationalDP.abstract_factoryDP.color.Color;

public class ShapeFactory extends AbstractFactory{

    @Override
    public Color getColor(String colorType) {
        return null;
    }

    public Shape getShape(String shapeType){
        if (shapeType==null){
            return null;
        }
        if (shapeType.equalsIgnoreCase("rectangle") || shapeType.equalsIgnoreCase("dikdortgen")){
            return new Rectangle();
        }else if(shapeType.equalsIgnoreCase("square")){
            return new Square();
        }else if(shapeType.equalsIgnoreCase("circle")){
            return new Circle();
        }
        return null;
    }

}
