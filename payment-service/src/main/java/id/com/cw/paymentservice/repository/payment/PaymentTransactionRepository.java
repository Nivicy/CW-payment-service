package id.com.cw.paymentservice.repository.payment;

import id.com.cw.paymentservice.model.entity.payment.PaymentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentTransactionRepository extends JpaRepository<PaymentTransaction, String> {
}
