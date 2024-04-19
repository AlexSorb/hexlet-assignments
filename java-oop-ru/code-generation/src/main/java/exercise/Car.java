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
        return new ObjectMapper().writeValueAsString(this);
    }
    @SneakyThrows
    public static Car unserialize(String jsonData) {
        return new ObjectMapper().readValue(jsonData, Car.class);
    }
    // END
}
