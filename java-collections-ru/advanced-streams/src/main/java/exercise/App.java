package exercise;

import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
public class App {
    public static String getForwardedVariables(String text) {
       return Arrays.stream(text.split("\n"))
               .filter(line -> line.startsWith("environment"))
               .map(line -> {
                   String newLine = line.replaceAll("environment=\"", "");
                   newLine = newLine.replaceAll("\"", "");
                   return newLine.split(",");

               })
               .flatMap(Arrays::stream)
               .filter(stay -> stay.startsWith("X_FORWARDED_"))
               .map(stay -> stay.replaceAll("X_FORWARDED_", ""))
               .collect(Collectors.joining(","));
    }
}
//END
