import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class AssignmentJava {
    /* - Type code to ask user to enter the int elements and add elements into the list
        - Ask user to enter the elements to remove, then remove that element from list.
        - Ask user to enter the element to update, then update it.

  */
    public static void main(String[] args) {

        updateEl(removeEl(addEl()));

    }

    public static List<Integer> addEl(){
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        System.out.println("Enter your list elements, press any letter to quit insetion!");
        while (in.hasNextInt()){
            list.add(in.nextInt());
        }
        System.out.println("Your list is: " + list);
        return list;
    }
    public static List<Integer> removeEl(List<Integer> list){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter num to be removed");
        while(scan.hasNextInt()){
            int a = scan.nextInt();
            list.remove(Integer.valueOf(a));
        }
        System.out.println(list);
        return list;
    }

    public static List<Integer> updateEl(List<Integer> list){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the numbers to be updated. First the existing one and next the new value!");
        while (scan.hasNextInt()){
            int a = scan.nextInt();
            int b = scan.nextInt();
            list.set(list.indexOf(a), b);
        }
        System.out.println(list);
        return list;
    }

}
/*
ListIterator<Integer> itr = list.listIterator();
        while (scan.hasNextInt()) {
            while (itr.hasNext()){
                int el = itr.next();
                if (el == scan.nextInt()){
                    itr.remove();
                    break;
                }

            }
        }
        System.out.println("Your list after removal of numbers: " + list);
 */
/*
 ListIterator<Integer> itr = list.listIterator();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter num to update then new value press any letter to end assertion");
        while (in.hasNextInt()){
            while (itr.hasNext()){
                int num = itr.next();
                if (num == in.nextInt()){
                    itr.set(in.nextInt());
                }
            }
        }
        System.out.println(list);
 */