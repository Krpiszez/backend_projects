package assignment_01_10;

import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HashTableAssignment {
    public static int id = 1;// here our static variable will determine the id as key of our value and never be same for new value
    public static int idAfterRemoval = 1; // here manipulating the id after removing element so the id would be the removed
                                          // elements id and fill the blank.
    public static void main(String[] args) {
        Hashtable<Integer, Employees> myTable = new Hashtable<>();
        Employees emp1 = new Employees("Tom", "Hanks");
        Employees emp2 = new Employees("Angelina", "Jolie");
        Employees emp3 = new Employees("Brad", "Pitt");
        Employees emp4 = new Employees("Salih", "Umut");
        Employees emp5 = new Employees("Jacek", "Piotrusz");
        Employees emp6 = new Employees("Andrej", "Lewandovski");
        addElement(myTable, emp1);
        addElement(myTable, emp2);
        addElement(myTable, emp3);
        System.out.println(myTable);
        getElement(myTable, 2);
        changeElement(myTable, "Pitt", "Pitto");
        System.out.println(myTable);
//        changeElementById(myTable, 2, "s");
//        System.out.println(myTable);
        // TESTING IF REMOVING AND SETTING THE ID WORKS PROPERLY
        System.out.println(id);
        removeElements(myTable, 2);
        System.out.println(myTable);
        System.out.println(id);
        addElement(myTable,emp4);
        System.out.println(myTable);
        addElement(myTable, emp5);
        System.out.println(myTable);
        System.out.println(id);
        System.out.println(idAfterRemoval);
        removeElements(myTable, 3);
        System.out.println(myTable);
        addElement(myTable,emp6);
        System.out.println(myTable);
        addElement(myTable,emp2);
        System.out.println(myTable);
    }

    public static void addElement(Hashtable<Integer, Employees> myTable, Employees employee){
        if (id==idAfterRemoval){
            myTable.put(id, employee);
            id++;
            idAfterRemoval++;
        }else {
            myTable.put(idAfterRemoval, employee);
            idAfterRemoval=id;
        }


    }

    public static void getElement(Hashtable<Integer, Employees> myTable, int getId){
        System.out.println("Element with the id "+ getId + " is "  + myTable.get(getId));
    }

    public static void changeElement(Hashtable<Integer, Employees> myTable, String surname,String newSurname){

        List<Employees> surnameToBeChanged = myTable.values().stream().filter(t-> t.surname.equals(surname)).collect(Collectors.toList());
        surnameToBeChanged.get(0).surname = newSurname;

    }

    public static void changeElementById(Hashtable<Integer, Employees> myTable, int idNum, String surname){
        myTable.get(idNum).surname=surname;
    }

    public static void removeElements(Hashtable<Integer, Employees> myTable, int idNum){
        myTable.remove(idNum);
        idAfterRemoval = idNum;
    }




}
