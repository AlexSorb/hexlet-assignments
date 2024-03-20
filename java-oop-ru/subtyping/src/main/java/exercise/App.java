package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
     var setElements = storage.toMap().entrySet();
     for ( var element : setElements) {
         storage.set(element.getValue(), element.getKey());
         storage.unset(element.getKey());
     }
    }
}
// END
