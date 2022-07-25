package peaksoft.airbnb_j.exceptions;

/**
 * @author Muhammed Toichubai
 */
public class NotFoundException extends RuntimeException{
    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
    }
}
