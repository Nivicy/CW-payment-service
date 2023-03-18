package id.com.cw.paymentservice.model.request.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PostUserUpdateAmountRequest {

    @NotBlank
    private String userId;

    @NotNull
    private BigDecimal minesAmount;
}
