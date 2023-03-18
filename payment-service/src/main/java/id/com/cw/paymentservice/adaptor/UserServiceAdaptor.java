package id.com.cw.paymentservice.adaptor;

import id.com.cw.paymentservice.model.request.user.PostUserUpdateAmountRequest;
import id.com.cw.paymentservice.model.response.user.GetUserAmountResponse;
import id.com.cw.paymentservice.model.response.user.PostUserUpdateAmountResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Log4j2
@Component
public class UserServiceAdaptor {

    @Value("${integration.user-service.check-amount.url}")
    private String userServiceCheckAmountUrl;

    @Value("${integration.user-service.update-amount.url}")
    private String userServiceUpdateAmountUrl;
    private RestTemplate restTemplate;

    public UserServiceAdaptor(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public GetUserAmountResponse getUserResponse(String userId){
        log.info("Try to access url : " + userServiceCheckAmountUrl);

        UriComponents uriComponents = UriComponentsBuilder
                .fromHttpUrl(userServiceCheckAmountUrl)
                .queryParam("userId", userId)
                .build();

        return restTemplate.exchange(
                uriComponents.toString(),
                HttpMethod.GET,
                null,
                GetUserAmountResponse.class).getBody();

    }

    public PostUserUpdateAmountResponse postUserAmountUpdateResponse(PostUserUpdateAmountRequest request){
        log.info("Try to access url : " + userServiceUpdateAmountUrl);
        return restTemplate.exchange(userServiceUpdateAmountUrl,
                HttpMethod.POST,
                new HttpEntity<>(request),
                PostUserUpdateAmountResponse.class).getBody();

    }
}
