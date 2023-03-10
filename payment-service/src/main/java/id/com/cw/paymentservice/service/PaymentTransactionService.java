package id.com.cw.paymentservice.service;

import id.com.cw.paymentservice.model.entity.payment.PaymentTransaction;
import id.com.cw.paymentservice.repository.payment.PaymentTransactionRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class PaymentTransactionService {

    @Autowired
    private PaymentTransactionRepository paymentTransactionRepository;

    public PaymentTransaction addPaymentTransaction(PaymentTransaction paymentTransaction){
        return paymentTransactionRepository.save(paymentTransaction);
    }
}
