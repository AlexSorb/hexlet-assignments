package exercise;

import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// BEGIN
public class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> listMan) {
        return listMan.stream()
                .filter(person -> person.get("gender").equals("male"))
                .sorted((men1, men2) -> {
                    var split1 = men1.get("birthday").split("-");
                    var split2 = men2.get("birthday").split("-");
                    LocalDate m1 = LocalDate.of(Integer.parseInt(split1[0])
                            , Integer.parseInt(split1[1])
                            , Integer.parseInt(split1[2]));
                    LocalDate m2 = LocalDate.of(Integer.parseInt(split2[0])
                            , Integer.parseInt(split2[1])
                            , Integer.parseInt(split2[2]));
                    return m1.compareTo(m2);
                })
                .map(men -> men.get("name"))
                .toList();
    }
}
// END
