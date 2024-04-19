package exercise;

import lombok.SneakyThrows;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

// BEGIN
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    @SneakyThrows
    public String serialize() {
        var result = new ObjectMapper().writeValueAsString(this);
        return result;
    }
    @SneakyThrows
    public static Car unserialize(String jsonData) {
        var result = new ObjectMapper().readValue(jsonData, Car.class);
        return result;
    }
    // END
}
