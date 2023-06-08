package clone_method;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EmptyStackException;

public class Stack implements Cloneable{
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public String stackName;

    public Stack() {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public String getStackName() {
        return stackName;
    }

    public void setStackName(String stackName) {
        this.stackName = stackName;
    }

    public void push(Object e){
        ensureCapacity();
        elements[size++] = e;
    }

    public Object  pop(){
        if (size==0){
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference
        return result;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }



    public static void main(String[] args) throws CloneNotSupportedException {
        int[] arr = {1,2,3,4};

        Stack st1 = new Stack();

        for (int w: arr){
            st1.push(w);
        }

        Stack clone = (Stack) st1.clone();

        while (!st1.isEmpty()){
            System.out.print(st1.pop() + " ");
        }
        System.out.println();
        while (!clone.isEmpty()){
            System.out.print(clone.pop() + " ");
        }

    }

    @Override
    public Stack clone() { // Without overriding clone method for its own usage the object created by using this method in raw
        // version will be affected the updates that is done in original object kinda mutable.
        try {
            Stack clone = (Stack) super.clone();
            clone.elements = elements.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
