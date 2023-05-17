package comparable_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        Book book1 = new Book("Ulysses", 400);
        Book book2 = new Book("The Great Gatsby", 300);
        Book book3 = new Book("War and Peace", 200);
        SortByName sortByName = new SortByName();
        List<Book> bookList = new ArrayList<>(List.of(book1, book2, book3));
        System.out.println(bookList);
        Collections.sort(bookList);
        System.out.println(bookList);
        Collections.sort(bookList, sortByName);
        System.out.println(bookList);

    }
}
