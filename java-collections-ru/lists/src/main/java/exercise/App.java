package exercise;

//import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public  class App {
    public static boolean scrabble(String characters, String word) {
        if (characters.length() < word.length()) {
            return false;
        }

        List<Character> listCharactersOfWord = new ArrayList<>();
        for (var sw: word.toLowerCase().toCharArray()) {
            listCharactersOfWord.add(sw);
        }
        List<Character> charArrays = new ArrayList<>();
        for (var sw: characters.toLowerCase().toCharArray()) {
            charArrays.add(sw);
        }
        for (var ch: listCharactersOfWord) {
            if (!charArrays.contains(ch)) {
                return false;
            }
            charArrays.remove(charArrays.indexOf(ch));
        }
        return true;
    }
}
//END
