package exercise;

import lombok.SneakyThrows;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    @SneakyThrows
    public static void save(Path pathOfFile, Car car) {
        Files.writeString(pathOfFile, car.serialize());
    }
    @SneakyThrows
    public static Car extract(Path pathOfFile) {
        var data = Files.readString(pathOfFile);
        return Car.unserialize(data);
    }
}
// END
