package exceptions;

/**
 * Exception that can be thrown when it's impossible to build city with specified fields values
 */
public class UnableToCreateCityException extends RuntimeException{
    @Override
    public String getMessage(){
        return "Unable to handle the city!";
    }
}
