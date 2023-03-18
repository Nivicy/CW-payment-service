package id.com.cw.paymentservice.configuration;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.httpcomponents.PoolingHttpClientConnectionManagerMetricsBinder;
import lombok.extern.log4j.Log4j2;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@Log4j2
public class AdaptorConfiguration {

    @Autowired
    private MeterRegistry meterRegistry;


    @Bean(name = "restTemplate")
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate(customHttpRequestFactory());

        return restTemplate;
    }

    @Bean
    public HttpComponentsClientHttpRequestFactory customHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient());
        httpComponentsClientHttpRequestFactory.setConnectionRequestTimeout(1000000);
        httpComponentsClientHttpRequestFactory.setReadTimeout(1000000);
        httpComponentsClientHttpRequestFactory.setConnectTimeout(1000000);
        return httpComponentsClientHttpRequestFactory;
    }

    @Bean
    public CloseableHttpClient httpClient(){
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        CloseableHttpClient defaultHttpClient = HttpClientBuilder.create().setConnectionManager(connectionManager).build();
        connectionManager.setMaxTotal(1000000);
        connectionManager.setDefaultMaxPerRoute(100);
        new PoolingHttpClientConnectionManagerMetricsBinder(connectionManager, "nivicy-pool").bindTo(meterRegistry);
        return defaultHttpClient;
    }
}
