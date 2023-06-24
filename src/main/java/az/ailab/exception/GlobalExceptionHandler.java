package az.ailab.exception;

import az.ailab.dto.GenericResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  @NotNull HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  @NotNull WebRequest request) {
        GenericResponse<Object> errorResponse = GenericResponse.builder()
                .timestamp(OffsetDateTime.now())
                .status(status.value())
                .key("NOT_VALID_ARGUMENT")
                .build();
        ex.getBindingResult().getFieldErrors().forEach(fieldError ->
                errorResponse.addValidationError(fieldError.getField(),
                        fieldError.getDefaultMessage()));
        return new ResponseEntity<>(errorResponse, status);

    }


    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<GenericResponse<Void>> handlePasswordDoesNotValidException(NotFoundException exception) {
        GenericResponse<Void> response = GenericResponse.failure(404, "failure", exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<GenericResponse<Void>> handleUsernameNotFoundException(BadRequestException exception) {
        GenericResponse<Void> response = GenericResponse.failure(400, "failure", exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}