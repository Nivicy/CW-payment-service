package id.com.cw.paymentservice.util.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorMessage {

    public static final String ERR_401_MSG = "Unauthorized";
    public static final String ERR_PRODUCT_1_MSG = "Product not found";
    public static final String ERR_PRODUCT_2_MSG = "Out of Stock";

}
