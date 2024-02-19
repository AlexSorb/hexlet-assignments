package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
public class App {

    public static final List<String> FREE_DOMAINS= List.of("gmail.com", "yandex.ru", "hotmail.com");
    public static long getCountOfFreeEmails(List<String> emails) {
        return emails.stream()
                .map(email -> {
                    var splitEmail = email.split("@");
                    return splitEmail[1];
                })
                .filter(FREE_DOMAINS::contains)
                .count();
    }
}
// END
