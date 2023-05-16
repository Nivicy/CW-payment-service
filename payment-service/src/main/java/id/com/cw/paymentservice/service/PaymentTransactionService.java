package id.com.cw.paymentservice.service;

import id.com.cw.paymentservice.exception.BusinessException;
import id.com.cw.paymentservice.model.entity.payment.PaymentTransaction;
import id.com.cw.paymentservice.repository.payment.PaymentTransactionRepository;
import id.com.cw.paymentservice.repository.product.ProductDetailRepository;
import id.com.cw.paymentservice.util.constants.Constans;
import id.com.cw.paymentservice.util.constants.ErrorCode;
import id.com.cw.paymentservice.util.constants.ErrorMessage;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class PaymentTransactionService {

    @Autowired
    private PaymentTransactionRepository paymentTransactionRepository;

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @SneakyThrows
    public PaymentTransaction addPaymentTransaction(PaymentTransaction paymentTransaction){
        var productDetail = productDetailRepository.findByProductId(paymentTransaction.getProductId())
                .orElseThrow(() -> new BusinessException(ErrorCode.ERR_PRODUCT_1, ErrorMessage.ERR_PRODUCT_1_MSG));
        if (productDetail.getStock() < 0){
            throw new BusinessException(ErrorCode.ERR_PRODUCT_2, ErrorMessage.ERR_PRODUCT_2_MSG);
        }

        //kurangin sisa stock di DB cw_product.product_detail dengan jumlah yang dibeli
        paymentTransaction.setStatus(Constans.STATUS_SUCCESS);
        paymentTransaction.setCapitalPricePerItem(productDetail.getCapitalPricePerItem());
        paymentTransaction.setCreatedBy("SYSTEM");
        paymentTransaction.setCreatedTime(Timestamp.valueOf(LocalDateTime.now()));
        paymentTransaction.setUpdatedBy("SYSTEM");
        paymentTransaction.setUpdatedTime(Timestamp.valueOf(LocalDateTime.now()));
        return paymentTransactionRepository.save(paymentTransaction);
    }
}
