package exercise;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {

    public static void save(Path pathOfFile, Car car) throws IOException {
        Files.writeString(pathOfFile, car.serialize(), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
    }

    public static Car extract(Path pathOfFile) throws IOException {
        var data = Files.readString(pathOfFile);
        return Car.unserialize(data);
    }
}
// END
