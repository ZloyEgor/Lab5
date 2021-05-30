package exceptions;

/**
 * Exception that can be thrown when field value doesn't meet the requirements
 */
public class InvalidFieldException extends RuntimeException{
    public InvalidFieldException(String message){
        super(message);
    }
}
