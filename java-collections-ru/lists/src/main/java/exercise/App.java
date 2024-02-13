package exercise;

//import java.util.Arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

// BEGIN
public  class App {
    public static boolean scrabble(String characters, String word) {

        List<String> listSymbolsOfWord = new ArrayList<>(Arrays.asList(word.toLowerCase().split("")));
        List<String> listSymbolsOfCharacters =
                new ArrayList<>(Arrays.asList(characters.toLowerCase().split("")));
        for (String character: listSymbolsOfWord) {
            if (!listSymbolsOfCharacters.contains(character)) {
                return false;
            }
            listSymbolsOfCharacters.remove(listSymbolsOfCharacters.indexOf(character));
        }
        return true;
    }
}
//END
