package id.com.cw.paymentservice.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ToString
@ResponseStatus(value = HttpStatus.CONFLICT)
public class BaseException extends RuntimeException{

    protected HttpStatus httpStatus;
    protected String errorCode;
    protected String errorMessage;

    public BaseException(HttpStatus httpStatus, String errorCode, String errorMessage){
        super(errorCode);
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public BaseException(String errorCode, String errorMessage){
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;

    }

}
