package az.ailab.exception;

import az.ailab.dto.GenericResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
}