package peaksoft.airbnb_j.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import peaksoft.airbnb_j.exceptions.BadRequestException;
import peaksoft.airbnb_j.exceptions.ExceptionResponse;
import peaksoft.airbnb_j.exceptions.ForbiddenException;
import peaksoft.airbnb_j.exceptions.NotFoundException;

/**
 * @author Muhammed Toichubai
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    //404
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handlerNotFoundException(NotFoundException e) {
        return new ExceptionResponse(
                HttpStatus.NOT_FOUND,
                e.getClass().getSimpleName(),
                e.getMessage()
        );

    }

    //400
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handlerBadRequestException(BadRequestException e) {
        return new ExceptionResponse(
                HttpStatus.NOT_FOUND,
                e.getClass().getSimpleName(),
                e.getMessage()
        );
    }

    //403
    @ExceptionHandler(ForbiddenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ExceptionResponse handlerForbiddenException(ForbiddenException e) {
        return new ExceptionResponse(
                HttpStatus.NOT_FOUND,
                e.getClass().getSimpleName(),
                e.getMessage()
        );
    }
}

