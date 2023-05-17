package comparable_comparator;

import java.util.Comparator;

import static java.util.Comparator.comparing;

public class Book implements Comparable<Book>{

    String name;
    int page;

    public Book(String name, int page) {
        this.name = name;
        this.page = page;
    }

    private static final Comparator<Book> COMPARATOR =
            comparing((Book bk) -> bk.name)
                    .thenComparingInt(bk -> bk.page);

    @Override
    public String toString() {
        return "{" + name +", " + page + "}";
    }

    @Override
    public int compareTo(Book o) {
        return this.page - o.page;
    }

//    public int compareTo(Book o){ // this can be used to implement Comparator directly to class which implemented Comparable
//        return COMPARATOR.compare(this, o);
//    }
}
