package id.com.cw.paymentservice.exception.handler;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiException extends Exception{

    private HttpStatus status;
    private String errorCode;
    private String errorMessage;

    public ApiException(HttpStatus status, String errorCode, String errorMessage) {
        super();
        this.status = status;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

}
