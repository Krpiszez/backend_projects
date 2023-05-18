package composition_inheritance;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {


        Book book1 = new Book("Java");
        Book book2 = new Book("Python");

        List<Book> bookList = new ArrayList<>(List.of(book1, book2));

        Library library1 = new Library(bookList);

        for (Book l: library1.allBooksInLibrary()){
            System.out.println(l.getName());
        }
    }
}
