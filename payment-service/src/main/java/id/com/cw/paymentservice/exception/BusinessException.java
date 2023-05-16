package id.com.cw.paymentservice.exception;


import org.springframework.http.HttpStatus;

public class BusinessException extends BaseException{

    public BusinessException(HttpStatus httpStatus, String errorCode, String errorDesc) {
        super(httpStatus, errorCode, errorDesc);
    }

    public BusinessException(String errorCode, String errorDesc) {
        super(HttpStatus.CONFLICT, errorCode, errorDesc);
    }
}
