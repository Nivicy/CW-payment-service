package id.com.cw.paymentservice.configuration.properties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@ConfigurationProperties(prefix = "integration")
@ConstructorBinding
@RequiredArgsConstructor
@Getter
@Validated
public class AdaptorConfigProperty {

    @Min(1000)
    private final int connectTimeout;

    @Min(1000)
    private final int readTimeout;

    @Positive
    private final int maxTotalConnections;

    @Positive
    private final int defaultMaxConnectionsPerRoute;

    @Min(1000)
    private final int connectionRequestTimeout;

    @Valid
    private final UserService userService;

    @RequiredArgsConstructor
    @Getter
    public static class UserService {

        @NotBlank
        private final String checkAmount;

        @NotBlank
        private final String updateAmount;

    }
}
