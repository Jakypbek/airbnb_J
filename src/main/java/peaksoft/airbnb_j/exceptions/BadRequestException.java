package peaksoft.airbnb_j.exceptions;

/**
 * @author Muhammed Toichubai
 */
public class BadRequestException extends RuntimeException{
    public BadRequestException() {
        super();
    }

    public BadRequestException(String message) {
        super(message);
    }
}
