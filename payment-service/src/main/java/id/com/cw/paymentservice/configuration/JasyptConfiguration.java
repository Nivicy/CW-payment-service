package id.com.cw.paymentservice.configuration;

import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JasyptConfiguration {

    @Value("${jasypt.passwordEncrypt}")
    private String passwordEncrypt;

    @Bean(name = "jasyptStringEncryptor")
    public BasicTextEncryptor encryptor(){
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPasswordCharArray(passwordEncrypt.toCharArray());
        return textEncryptor;
    }
}
