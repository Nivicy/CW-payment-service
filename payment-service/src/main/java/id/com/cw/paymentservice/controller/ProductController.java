package id.com.cw.paymentservice.controller;

import id.com.cw.paymentservice.model.entity.product.ProductDetail;
import id.com.cw.paymentservice.service.ProductDetailService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/v1")
@Api(tags = "Product Service")
@RequiredArgsConstructor
public class ProductController {

    //This is using required Argument Constructor
    private final ProductDetailService productDetailService;

    @PostMapping("/addProduct")
    public ProductDetail addProductDetail(@RequestBody ProductDetail productDetail){
        return productDetailService.addProductDetail(productDetail);
    }

}
