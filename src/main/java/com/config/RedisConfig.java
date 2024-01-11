/*package com.config;

import org.redisson.Redisson;
import org.redisson.config.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

*//**
 * @author LiuCheng
 * @date 2021/4/19 19:06
 *//*
@Configuration
public class RedisConfig {
    @Value("${password}")
    private String password;
    @Value("#{'${nodeAddresses}'.split(',')}")
    private List<String> nodeAddresses;

    @Bean
    public Redisson redisson() {
        Config config = new Config();
       
        SingleServerConfig singleServerConfig = config.useSingleServer();
        singleServerConfig.setAddress(nodeAddresses.get(0));
        singleServerConfig.setPassword(password);
        
        return (Redisson) Redisson.create(config);
    }
}
*/