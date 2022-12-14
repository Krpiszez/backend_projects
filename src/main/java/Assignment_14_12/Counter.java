package Assignment_14_12;

import java.util.Collection;
import java.util.function.Predicate;

public class Counter {
    public static <T> long countIf(Collection<T> collection, Predicate<T> predicate) {
        return collection.stream()
                .filter(predicate)
                .count();
    }
}
