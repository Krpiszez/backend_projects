package assignment_01_10;

import java.util.Scanner;
import java.util.Stack;

public class StackAssignment {

    public static void main(String[] args) {

        //delElFromStack(addElIntoStack(createStackObject()));
        //numberOfItems(addElIntoStack(createStackObject()));
        //showMin(addElIntoStack(createStackObject()));
        //showMax(addElIntoStack(createStackObject()));
        findItem(addElIntoStack(createStackObject()));
        //printStack(addElIntoStack(createStackObject()));

    }
    public static Stack<Integer> createStackObject(){
        return new Stack<>();
    }
    public static Stack<Integer> addElIntoStack(Stack<Integer> stack){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter numbers to Add to your Stack. Press any letter to end insertion!");
        while (in.hasNextInt()) {
            stack.push(in.nextInt());
        }
        return stack;
    }
    public static void delElFromStack(Stack<Integer> stack){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter numbers to remove from your Stack. Press any letter to end insertion!");
        while (in.hasNextInt()) {
            stack.remove(Integer.valueOf(in.nextInt()));
        }
        System.out.println(stack);
    }
    public static int numberOfItems(Stack<Integer> stack){
        int numberOfItems = stack.size();
        System.out.println("There are " + numberOfItems + " elements in your stack.");
        return numberOfItems;
    }
    public static int showMin(Stack<Integer> stack){
        int min = stack.get(0);
        for (int i = 0; i < stack.size(); i++) {
            min = Math.min(min, stack.get(i));
        }
        System.out.println("The Minimum Number in your Stack is: " + min);
        return min;
    }
    public static int showMax(Stack<Integer> stack){
        int max = stack.get(0);
        for (int i = 0; i < stack.size(); i++) {
            max = Math.max(max, stack.get(i));
        }
        System.out.println("The Minimum Number in your Stack is: " + max);
        return max;
    }
    public static void findItem(Stack<Integer> stack){
        Scanner scan = new Scanner(System.in);
        System.out.println("Which element you want to find");
        int numToFind = scan.nextInt();
        if (stack.contains(numToFind)){
            System.out.println("Index of the element you are looking for: " + stack.indexOf(numToFind));
        }else {
            System.out.println("Your stack does not contain this number!");
        }

    }
    public static void printStack(Stack<Integer> stack){
        System.out.println(stack);
    }


}
