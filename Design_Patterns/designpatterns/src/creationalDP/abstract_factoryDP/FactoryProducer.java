package creationalDP.abstract_factoryDP;

import creationalDP.abstract_factoryDP.color.ColorFactory;
import creationalDP.abstract_factoryDP.shape.ShapeFactory;

public class FactoryProducer { // here we are actually dividing to structure into smaller pieces which saves us writing
    // complicated if-else conditional codes
    public static AbstractFactory getFactory(String choice){
        if (choice.equalsIgnoreCase("shape")){
            return new ShapeFactory();
        } else if (choice.equalsIgnoreCase("color")) {
            return new ColorFactory();
        }
        return null;
    }
}
