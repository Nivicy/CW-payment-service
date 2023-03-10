package id.com.cw.paymentservice.model.entity.payment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "payment_trx", schema = "cw")
public class PaymentTransaction implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "payment_trx_id")
    private String paymentTrxId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "dealer_id")
    private String dealerId;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "qty")
    private Integer qty;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "capital_price_per_item")
    private BigDecimal capitalPricePerItem;

    @Column(name = "status")
    private String status;

    @Column(name = "category")
    private String category;

    @Column(name = "created_time")
    private Timestamp createdTime;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_time")
    private Timestamp updatedTime;

    @Column(name = "updated_by")
    private String updatedBy;
}
