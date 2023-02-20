package assignment_01_10;

import java.util.*;

public class QueueAssignment {

    public static void main(String[] args) {

        Queue<Integer> myQueue = new LinkedList<>();
        addElIntoQueue(myQueue);
        delElFromQueue(myQueue);
        numberOfItems(myQueue);
        showMin(myQueue);
        showMax(myQueue);
        findItem(myQueue);
        printQueue(myQueue);




    }
    public static Queue<Integer> addElIntoQueue(Queue<Integer> queue){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter numbers to Add to your Stack. Press any letter to end insertion!");
        while (in.hasNextInt()) {
            queue.add(in.nextInt());
        }
        System.out.println("Your queue after adding elements: " + queue);
        return queue;
    }
    public static void delElFromQueue(Queue<Integer> queue){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter numbers to remove from your Stack. Press any letter to end insertion!");
        while (in.hasNextInt()) {
            queue.remove(in.nextInt());
        }
        System.out.println("Your queue after deleting elements: " + queue);
    }
    public static int numberOfItems(Queue<Integer> queue){
        int numberOfItems = queue.size();
        System.out.println("There are " + numberOfItems + " elements in your stack.");
        return numberOfItems;
    }
    public static int showMin(Queue<Integer> queue){
        int min = Integer.MAX_VALUE;
        for (Integer w: queue){
            min = Math.min(min, w);
        }
        System.out.println("The Minimum Number in your Stack is: " + min);
        return min;
    }
    public static int showMax(Queue<Integer> queue){
        int max = Integer.MIN_VALUE;
        for (Integer w: queue){
            max = Math.max(max, w);
        }
        System.out.println("The Maximum Number in your Stack is: " + max);
        return max;
    }
    public static void findItem(Queue<Integer> queue){
        Scanner scan = new Scanner(System.in);
        System.out.println("Which element you want to find");
        int numToFind = scan.nextInt();
        if (queue.contains(numToFind)){
            System.out.println(numToFind + " is in your Queue.");
        }else {
            System.out.println(numToFind + " is not in your Queue.");
        }

    }
    public static void printQueue(Queue<Integer> queue){
        System.out.println(queue);
    }


}
