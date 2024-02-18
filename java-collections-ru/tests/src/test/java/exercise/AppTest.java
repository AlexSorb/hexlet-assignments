package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppTest {
    List<Integer> numbers;

    @BeforeEach
    void init() {
        numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
    }
    @Test
    void testTake() {
        // BEGIN
        List<Integer> answer = App.take(numbers, 2);
        List<Integer> right = numbers.subList(0, 2);
        Assertions.assertArrayEquals(answer.toArray(), right.toArray());
        // END
    }
}
