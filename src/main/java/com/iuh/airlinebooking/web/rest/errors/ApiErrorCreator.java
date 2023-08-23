package com.iuh.airlinebooking.web.rest.errors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.context.request.WebRequest;
import org.terasoluna.gfw.common.message.ResultMessage;
import org.terasoluna.gfw.common.message.ResultMessages;

public class ApiErrorCreator {
    private MessageSource messageSource;

    @Autowired
    public ApiErrorCreator(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public ApiError createApiError(WebRequest request, String errorCode, String defaultErrorMessage,
                                   Object... arguments) {
        String localizedMessage = messageSource.getMessage(errorCode, arguments, defaultErrorMessage,
                request.getLocale());
        return new ApiError(errorCode, localizedMessage);
    }

    public ApiError createBindingResultApiError(WebRequest request, String errorCode, BindingResult bindingResult,
                                                String defaultErrorMessage) {
        ApiError apiError = createApiError(request, errorCode, defaultErrorMessage);
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            apiError.addDetail(createApiError(request, fieldError, fieldError.getField()));
        }
        for (ObjectError objectError : bindingResult.getGlobalErrors()) {
            apiError.addDetail(createApiError(request, objectError, objectError.getObjectName()));
        }
        return apiError;
    }

    private ApiError createApiError(WebRequest request, DefaultMessageSourceResolvable messageResolvable,
                                    String target) {
        String localizedMessage = messageSource.getMessage(messageResolvable, request.getLocale());
        return new ApiError(messageResolvable.getCode(), localizedMessage, target);
    }

    public ApiError createResultMessagesApiError(WebRequest request, String rootErrorCode,
                                                 ResultMessages resultMessages, String defaultErrorMessage) {
        ApiError apiError;
        if (resultMessages.getList().size() == 1) {
            ResultMessage resultMessage = resultMessages.iterator().next();
            String errorCode = resultMessage.getCode();
            String errorText = resultMessage.getText();
            if (errorCode == null && errorText == null) {
                errorCode = rootErrorCode;
            }
            apiError = createApiError(request, errorCode, errorText, resultMessage.getArgs());
        } else {
            apiError = createApiError(request, rootErrorCode, defaultErrorMessage);
            for (ResultMessage resultMessage : resultMessages.getList()) {
                apiError.addDetail(createApiError(request, resultMessage.getCode(), resultMessage.getText(),
                        resultMessage.getArgs()));
            }
        }
        return apiError;
    }
}
