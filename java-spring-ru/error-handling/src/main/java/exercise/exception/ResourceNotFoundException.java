package exercise.exception;

// BEGIN
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String massage) {
        super(massage);
    }
}
// END
