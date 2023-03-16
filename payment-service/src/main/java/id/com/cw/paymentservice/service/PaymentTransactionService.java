package id.com.cw.paymentservice.service;

import id.com.cw.paymentservice.model.entity.payment.PaymentTransaction;
import id.com.cw.paymentservice.repository.payment.PaymentTransactionRepository;
import id.com.cw.paymentservice.repository.product.ProductDetailRepository;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static id.com.cw.paymentservice.util.constants.Constans.STATUS_SUCCESS;
import static id.com.cw.paymentservice.util.constants.ErrorMessage.*;
@Service
@Log4j2
public class PaymentTransactionService {

    @Autowired
    private PaymentTransactionRepository paymentTransactionRepository;

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @SneakyThrows
    public PaymentTransaction addPaymentTransaction(PaymentTransaction paymentTransaction){
        var productDetail = productDetailRepository.findById(paymentTransaction.getProductId()).orElseThrow(() -> new Exception(ERR_PRODUCT_1_MSG));
        if (productDetail.getStock() < 0){
            log.error(ERR_PRODUCT_2_MSG);
            throw new Exception(ERR_PRODUCT_2_MSG);
        }

        //kurangin sisa stock di DB cw_product.product_detail dengan jumlah yang dibeli
        paymentTransaction.setStatus(STATUS_SUCCESS);
        paymentTransaction.setCapitalPricePerItem(productDetail.getCapitalPricePerItem());
        paymentTransaction.setCreatedBy("SYSTEM");
        paymentTransaction.setCreatedTime(Timestamp.valueOf(LocalDateTime.now()));
        paymentTransaction.setUpdatedBy("SYSTEM");
        paymentTransaction.setUpdatedTime(Timestamp.valueOf(LocalDateTime.now()));
        return paymentTransactionRepository.save(paymentTransaction);
    }
}
