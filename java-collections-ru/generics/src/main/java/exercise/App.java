package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
public class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> search) {
        return books.stream()
                .filter((book) -> book.values().containsAll(search.values()))
                .toList();
    }
}
//END
