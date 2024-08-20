package exercise;

import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] array) {
        var maxThread = new MaxThread(array);
        var minThread = new MinThread(array);
        minThread.start();
        maxThread.start();
        try {
            minThread.join();
            maxThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return Map.of(
                "min", minThread.getMin(),
                "max", maxThread.getMax()
        );
    }
    // END
}
