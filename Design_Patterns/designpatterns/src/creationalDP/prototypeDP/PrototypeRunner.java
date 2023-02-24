package creationalDP.prototypeDP;

public class PrototypeRunner {

    public static void main(String[] args) { // Here instead of creating different objects for an object that is similar to another we just
        //implement Cloneable then override clone method from Object class. Then set fields on this new object.

        Soldier availableSoldier = new Soldier(100,95,3,75, 10, 99, "Axe", true);
        // Here just to change a single field of a new object we need an entire different object instead we use prototype below. (with clone())
        Soldier notAvailableSoldier = new Soldier(100,95,3,75, 10, 99, "Blade", false);

        availableSoldier.showSoldierInfo();
        System.out.println("--------------------");
        notAvailableSoldier.showSoldierInfo();
        System.out.println("--------------------");
        Soldier notAvailableSoldier2 = availableSoldier.clone();
        notAvailableSoldier2.setAvailableForWar(false);
        notAvailableSoldier2.showSoldierInfo();


    }
}
