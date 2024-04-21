package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.SneakyThrows;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

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

    public String serialize() {
        String result = null;
        try {
            result = new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static Car unserialize(String jsonData) {
        Car result = null;
        try {
            result = new ObjectMapper().readValue(jsonData, Car.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    // END
}
