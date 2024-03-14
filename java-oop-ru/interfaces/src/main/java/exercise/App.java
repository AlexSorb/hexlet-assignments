package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> buildingList, int size){
        var sortedList = buildingList.stream()
                .sorted(Home::compareTo)
                .map(house -> house.toString())
                .toList();
        if (size > sortedList.size()) {
            size = sortedList.size();
        }
        return sortedList.subList(0, size);
    }
}
// END
