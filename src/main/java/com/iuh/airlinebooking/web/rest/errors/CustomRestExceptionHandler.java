package com.iuh.airlinebooking.web.rest.errors;

import com.iuh.airlinebooking.security.UserNotActivatedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.terasoluna.gfw.common.exception.ExceptionCodeResolver;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;
import org.terasoluna.gfw.common.exception.ResultMessagesNotificationException;

@Slf4j
public abstract class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private ApiErrorCreator apiErrorCreator;
    @Autowired
    private ExceptionCodeResolver exceptionCodeResolver;

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        final Object apiError;
        if(body == null){
            String errorCode = exceptionCodeResolver.resolveExceptionCode(ex);
            apiError = apiErrorCreator.createApiError(request, errorCode, ex.getLocalizedMessage());
        }else {
            apiError = body;
        }
        return ResponseEntity.status(statusCode).headers(headers).body(apiError);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return handleBindingResult(ex, ex.getBindingResult(), headers, status, request);
    }

    private ResponseEntity<Object> handleBindingResult(Exception ex, BindingResult bindingResult, HttpHeaders headers,
                                                       HttpStatusCode statusCode, WebRequest request) {
        String errorCode = exceptionCodeResolver.resolveExceptionCode(ex);
        ApiError apiError = apiErrorCreator.createBindingResultApiError(request, errorCode, bindingResult,
                ex.getMessage());
        return handleExceptionInternal(ex, apiError, headers, statusCode, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        if (ex.getCause() instanceof Exception) {
            return handleExceptionInternal((Exception) ex.getCause(), null, headers, status, request);
        } else {
            return handleExceptionInternal(ex, null, headers, status, request);
        }
    }

    private ResponseEntity<Object> handleResultMessagesNotificationException(ResultMessagesNotificationException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String errorCode = exceptionCodeResolver.resolveExceptionCode(ex);
        ApiError apiError = apiErrorCreator.createResultMessagesApiError(request, errorCode, ex.getResultMessages(),
                ex.getMessage());
        return handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<Object> handleResourceNotFotFoundException(ResourceNotFoundException ex, WebRequest request){
        return handleResultMessagesNotificationException(ex, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleSystemError(Exception ex, WebRequest request){
        return handleExceptionInternal(ex, null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler({UserNotActivatedException.class})
    public ResponseEntity<Object> handleUserNotActivatedException(UserNotActivatedException ex, WebRequest request){
        return handleExceptionInternal(ex, null, new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
    }
}
