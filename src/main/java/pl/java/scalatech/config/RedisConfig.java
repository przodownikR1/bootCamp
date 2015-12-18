package pl.java.scalatech.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfig {
    //@Bean
   /* JedisConnectionFactory connectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName("localhost");
        factory.setPort(6379);
        return factory;
    }*/
    
    /*@Bean
    StringRedisTemplate template(JedisConnectionFactory connectionFactory) {
        return new StringRedisTemplate(connectionFactory);
    }*/
}
