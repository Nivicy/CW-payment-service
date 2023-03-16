package id.com.cw.paymentservice.service;

import id.com.cw.paymentservice.model.entity.payment.PaymentTransaction;
import id.com.cw.paymentservice.model.entity.product.ProductDetail;
import id.com.cw.paymentservice.repository.payment.PaymentTransactionRepository;
import id.com.cw.paymentservice.repository.product.ProductDetailRepository;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static id.com.cw.paymentservice.util.constants.Constans.STATUS_SUCCESS;
import static id.com.cw.paymentservice.util.constants.ErrorMessage.ERR_PRODUCT_1_MSG;
import static id.com.cw.paymentservice.util.constants.ErrorMessage.ERR_PRODUCT_2_MSG;

@Service
@Log4j2
public class ProductDetailService {

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @SneakyThrows
    public ProductDetail addProductDetail(ProductDetail productDetail){
        productDetail.setIsActive(Boolean.TRUE);
        productDetail.setCreatedBy("SYSTEM");
        productDetail.setCreatedTime(Timestamp.valueOf(LocalDateTime.now()));
        productDetail.setUpdatedBy("SYSTEM");
        productDetail.setUpdatedTime(Timestamp.valueOf(LocalDateTime.now()));
        return productDetailRepository.save(productDetail);
    }
}
