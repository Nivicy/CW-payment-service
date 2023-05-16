package id.com.cw.paymentservice.repository.product;

import id.com.cw.paymentservice.model.entity.product.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, String> {

    Optional<ProductDetail> findByProductId(String productId);
}
