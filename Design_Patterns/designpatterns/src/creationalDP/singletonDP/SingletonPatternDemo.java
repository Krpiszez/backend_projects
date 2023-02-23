package creationalDP.singletonDP;

public class SingletonPatternDemo {
    public static void main(String[] args) {

        SingleObject obj1 = new SingleObject(); // when we have a private constructor without
                                                // parameter object can not be created this way
        SingleObject obj2 = new SingleObject();

        SingleObject obj3 = SingleObject.getInstance();// by using the method we created in class from which we are going to create
        SingleObject obj4 = SingleObject.getInstance();// object we can use singletonDP all objects created this way will be same(reference - address)

        System.out.println(obj1==obj2);
        System.out.println(obj3==obj4);
        System.out.println(obj1==obj4);
        System.out.println("obj3.message = " + obj3.message);// HELLO
        obj3.changeMessage(); // "Batch 110-111";
        System.out.println("obj4.message = " + obj4.message);// HELLO Batch 110-111
    }
}
