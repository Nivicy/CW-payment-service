package id.com.cw.paymentservice.configuration;

import id.com.cw.paymentservice.configuration.properties.AdaptorConfigProperty;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@RequiredArgsConstructor
public class AdaptorConfiguration {

    private final AdaptorConfigProperty adaptorConfigProperty;

    @Bean(name = "restTemplate")
    public RestTemplate restTemplate(MeterRegistry meterRegistry) {
        RestTemplate restTemplate = new RestTemplate(customHttpRequestFactory(meterRegistry));

        return restTemplate;
    }

    @Bean
    public HttpComponentsClientHttpRequestFactory customHttpRequestFactory(MeterRegistry meterRegistry) {
        HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient());
        httpComponentsClientHttpRequestFactory.setConnectionRequestTimeout(adaptorConfigProperty.getConnectionRequestTimeout());
        httpComponentsClientHttpRequestFactory.setReadTimeout(adaptorConfigProperty.getReadTimeout());
        httpComponentsClientHttpRequestFactory.setConnectTimeout(adaptorConfigProperty.getConnectTimeout());
        return httpComponentsClientHttpRequestFactory;
    }

    @Bean
    public CloseableHttpClient httpClient(){
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        CloseableHttpClient defaultHttpClient = HttpClientBuilder.create().setConnectionManager(connectionManager).build();
        connectionManager.setMaxTotal(adaptorConfigProperty.getMaxTotalConnections());
        connectionManager.setDefaultMaxPerRoute(adaptorConfigProperty.getDefaultMaxConnectionsPerRoute());
        return defaultHttpClient;
    }
}
