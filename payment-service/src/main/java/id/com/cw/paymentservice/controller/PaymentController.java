package id.com.cw.paymentservice.controller;

import id.com.cw.paymentservice.model.entity.payment.PaymentTransaction;
import id.com.cw.paymentservice.service.PaymentTransactionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment/v1")
@Api(tags = "Payment Service")
public class PaymentController {

    //This style using autowired
    @Autowired
    private PaymentTransactionService paymentTransactionService;

    @PostMapping("/addTransaction")
    public PaymentTransaction addPaymentTransaction(@RequestBody PaymentTransaction paymentTransaction){
        return paymentTransactionService.addPaymentTransaction(paymentTransaction);
    }

}
