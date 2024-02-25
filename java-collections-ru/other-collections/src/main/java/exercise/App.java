package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
public class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> dictionary1,
                                                        Map<String, Object> dictionary2) {


        Set<String> setDic1 = new TreeSet<>(dictionary1.keySet());
        Set<String> setDic2 = new TreeSet<>(dictionary2.keySet());

        Set<String> union = new TreeSet<>(setDic1);
        union.addAll(setDic2);

        Set<String> intersection = new TreeSet<>(setDic1);
        intersection.retainAll(setDic2);

        Set<String> difference = new TreeSet<>(setDic2);
        difference.removeAll(setDic1);
        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        for (String item: union) {
            String status;
            if (intersection.contains(item)) {
                status = dictionary1.get(item) == dictionary2.get(item) ? "unchanged" : "changed";
            } else {
               status =  difference.contains(item) ? "added" : "deleted";
            }
            result.put(item, status);
        }
        return result;
    }
}
//END
