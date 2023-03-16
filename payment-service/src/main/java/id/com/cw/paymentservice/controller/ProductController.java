package id.com.cw.paymentservice.controller;

import id.com.cw.paymentservice.model.entity.payment.PaymentTransaction;
import id.com.cw.paymentservice.model.entity.product.ProductDetail;
import id.com.cw.paymentservice.service.PaymentTransactionService;
import id.com.cw.paymentservice.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/v1")
public class ProductController {

    @Autowired
    private ProductDetailService productDetailService;

    @PostMapping("/addProduct")
    public ProductDetail addProductDetail(@RequestBody ProductDetail productDetail){
        return productDetailService.addProductDetail(productDetail);
    }

}
