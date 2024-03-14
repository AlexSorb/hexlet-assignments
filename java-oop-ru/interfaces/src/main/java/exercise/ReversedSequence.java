package exercise;

// BEGIN
public class ReversedSequence implements CharSequence{
    String reversedString;

    public  ReversedSequence(String text) {
        reversedString = "";
        for (var character: text.toCharArray()) {
            reversedString = character + reversedString;
        }
    }

    @Override
    public int length() {
        return reversedString.length();
    }

    @Override
    public char charAt(int index) {
        return reversedString.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return reversedString.subSequence(start, end);
    }

    @Override
    public String toString() {
        return reversedString;
    }
}
// END
