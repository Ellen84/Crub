package be.argeus.CrudBack.controller;

import be.argeus.CrudBack.exceptions.SystemException;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(value = {SystemException.class})
    protected ResponseEntity<Problem> systemException(SystemException exception, WebRequest request) {
        LOG.error("Rest SystemException", exception);
        return new ResponseEntity<>(new Problem(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Problem> customHandleNotFound(Exception exception, WebRequest request) {
        LOG.error("Rest SystemException", exception);
        return new ResponseEntity<>(new Problem("Internal Server Error: " + exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static class Problem {
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
        private final LocalDateTime timestamp = LocalDateTime.now();
        private final String title;

        public Problem(String message) {
            this.title = message;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        public String getTitle() {
            return title;
        }
    }
}
