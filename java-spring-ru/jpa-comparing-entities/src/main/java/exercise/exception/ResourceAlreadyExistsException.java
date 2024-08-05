package exercise.exception;

// BEGIN
public class ResourceAlreadyExistsException extends RuntimeException{
    public ResourceAlreadyExistsException(String massage) {
        super(massage);
    }
}
// END
