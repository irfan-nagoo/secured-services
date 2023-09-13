package com.example.oidc.exception;

import com.example.oidc.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.UUID;

import static com.example.oidc.constants.MessagingConstants.PROCESSING_ERROR_MSG;

/**
 * @author irfan.nagoo
 */

@ControllerAdvice
@Slf4j
public class SampleControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        String errorId = UUID.randomUUID().toString();
        log.error("Record not found with errorId[{}]: ", errorId, e);
        return ResponseEntity.internalServerError().body(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.name(),
                PROCESSING_ERROR_MSG, errorId));
    }

}
