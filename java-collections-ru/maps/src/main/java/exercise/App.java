package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static Map<String, Integer> getWordCount(String text) {
        Map<String, Integer> result = new HashMap<>();
        if (text.isEmpty()) {
            return result;
        }
        var words = text.toLowerCase().split(" ");
        for (var word : words) {
            var count = result.getOrDefault(word, 0);
            result.put(word, count + 1);
        }
        return result;
    }

    public static String toString(Map<String, Integer> lib) {
        String result = "{";
        if (!lib.isEmpty()){
            result += "\n";
            for (var set: lib.entrySet()) {
                result += "  ";
                result += set.getKey() + ": ";
                result += set.getValue() + "\n";
            }
        }
        result+="}";
        return result;
    }
}
//END
