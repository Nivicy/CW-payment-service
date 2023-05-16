package id.com.cw.paymentservice.exception.handler;

import id.com.cw.paymentservice.exception.BaseException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Log4j2
public class ApiExceptionHandler {

    @ExceptionHandler(value = {BaseException.class})
    public ResponseEntity<Object> handleApiRequestException(BaseException baseException){
        ApiException apiException =  new ApiException(
                baseException.getHttpStatus(),
                baseException.getErrorCode(),
                baseException.getErrorMessage()
        );

        log.error("Cause by : " + baseException.getCause());
        baseException.printStackTrace();

        return new ResponseEntity<>(apiException, baseException.getHttpStatus());
    }
}
