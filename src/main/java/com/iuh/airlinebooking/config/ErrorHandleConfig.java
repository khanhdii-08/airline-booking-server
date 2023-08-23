package com.iuh.airlinebooking.config;


import com.iuh.airlinebooking.web.rest.errors.ApiErrorCreator;
import com.iuh.airlinebooking.messaging.MessageKeys;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.terasoluna.gfw.common.exception.SimpleMappingExceptionCodeResolver;

import java.util.LinkedHashMap;

@Configuration
public class ErrorHandleConfig {
    @Bean
    public SimpleMappingExceptionCodeResolver exceptionCodeResolver(){
        SimpleMappingExceptionCodeResolver exceptionCodeResolver = new SimpleMappingExceptionCodeResolver();
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

        map.put("ResourceNotFoundException"              , MessageKeys.E_EX_FW_404);
//        map.put("HttpRequestMethodNotSupportedException" , MessageKeys.E_EX_FW_6001);
//        map.put("MediaTypeNotAcceptableException"        , MessageKeys.E_EX_FW_6002);
//        map.put("HttpMediaTypeNotSupportedException"     , MessageKeys.E_EX_FW_6003);
//        map.put("MethodArgumentNotValidException"        , MessageKeys.E_EX_FW_7001);
//        map.put("BindException"                          , MessageKeys.E_EX_FW_7002);
//        map.put("JsonParseException"                     , MessageKeys.E_EX_FW_7003);
//        map.put("UnrecognizedPropertyException"          , MessageKeys.E_EX_FW_7004);
//        map.put("JsonMappingException"                   , MessageKeys.E_EX_FW_7005);
        map.put("TypeMismatchException"                  , MessageKeys.E_EX_FW_400);
//        map.put("BusinessException"                      , MessageKeys.E_EX_FW_8001);
//        map.put("OptimisticLockingFailureException"      , MessageKeys.E_EX_FW_8002);
//        map.put("PessimisticLockingFailureException"     , MessageKeys.E_EX_FW_8002);
//        map.put("DataAccessException"                    , MessageKeys.E_EX_FW_9002);
        map.put("UserNotActivatedException"                  , MessageKeys.E_EX_FW_401);


        exceptionCodeResolver.setExceptionMappings(map);
        exceptionCodeResolver.setDefaultExceptionCode(MessageKeys.E_EX_FW_500);

        return exceptionCodeResolver;
    }

    @Bean
    public ApiErrorCreator apiErrorCreator (MessageSource messageResource) {
        return new ApiErrorCreator(messageResource);
    }
}
