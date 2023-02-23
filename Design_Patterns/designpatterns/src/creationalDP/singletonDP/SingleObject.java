package creationalDP.singletonDP;

public class SingleObject {

    String message = "HELLO ";

    // here INSTANCE object is created.
    private static SingleObject instance = new SingleObject(); // this object is being used throughout project

    // here object is created by using instance object above.
    public static SingleObject getInstance(){
        return instance;
    }

    public void changeMessage(){
        this.message+= "Batch 110-111";
    }
}
