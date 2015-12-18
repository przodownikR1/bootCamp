package pl.java.scalatech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration

public class WebConfig extends WebMvcConfigurationSupport {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/internal/**").addResourceLocations("classpath:/");
    }

    @Bean
    public RestOperations restTemplate() {
        final RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory());
        // restTemplate.setInterceptors(Arrays.asList(requestTimer(), loadBalancerInterceptor));
        return restTemplate;
    }

    @Bean(name = "restClientHttpFactory")
    public ClientHttpRequestFactory clientHttpRequestFactory() {
        final SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        simpleClientHttpRequestFactory.setConnectTimeout(500);
        simpleClientHttpRequestFactory.setReadTimeout(300);
        return simpleClientHttpRequestFactory;
    }

}
