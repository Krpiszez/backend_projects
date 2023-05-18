package composition_inheritance;

import java.util.List;

public class Library { // here extension is not good because library IS NOT A Book

    private final List<Book> bookList;

    public Library(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Book> allBooksInLibrary() {
        return bookList;
    }
}
