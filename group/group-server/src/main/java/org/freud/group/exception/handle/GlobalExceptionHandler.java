package org.freud.group.exception.handle;

import lombok.extern.slf4j.Slf4j;
import org.freud.group.exception.FormException;
import org.freud.group.exception.GroupException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ApiError> runtimeException(RuntimeException e) {
        log.error(e.getMessage(), e);
        return buildResponseEntity(ApiError.error(e.getMessage()));
    }

    @ExceptionHandler(value = GroupException.class)
    public ResponseEntity<ApiError> GroupException(RuntimeException e) {
        log.error(e.getMessage());
        return buildResponseEntity(ApiError.error(e.getMessage()));
    }

    @ExceptionHandler(value = FormException.class)
    public ResponseEntity<ApiError> FormException(RuntimeException e) {
        log.error(e.getMessage());
        return buildResponseEntity(ApiError.error(e.getMessage()));
    }

    private ResponseEntity<ApiError> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, HttpStatus.valueOf(apiError.getStatus()));
    }
}
