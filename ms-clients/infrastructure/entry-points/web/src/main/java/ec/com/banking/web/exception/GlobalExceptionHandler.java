package ec.com.banking.web.exception;

import ec.com.banking.core.exception.ClientDuplicatedException;
import ec.com.banking.core.exception.ClientNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
        ValidationErrorResponse errorResponse = new ValidationErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getBindingResult().getFieldErrors()
                        .stream()
                        .filter(err -> err.getDefaultMessage() != null)
                        .collect(Collectors.toMap(
                                FieldError::getField,
                                err -> String.format("Field '%s': %s", err.getField(), err.getDefaultMessage()),
                                (msg1, msg2) -> msg1
                        )));

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> handleClientNotFound(ClientNotFoundException ex) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ClientDuplicatedException.class)
    public ResponseEntity<CustomErrorResponse> handleClientDuplicated(ClientDuplicatedException ex) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(
                HttpStatus.CONFLICT.value(),
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

}
