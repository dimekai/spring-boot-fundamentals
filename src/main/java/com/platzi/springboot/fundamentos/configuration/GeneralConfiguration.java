package com.platzi.springboot.fundamentos.configuration;

import com.platzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.platzi.springboot.fundamentos.bean.MyBeanWithPropertiesImplement;
import com.platzi.springboot.fundamentos.pojo.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(User.class)
public class GeneralConfiguration {
    @Value("${value.name}")
    private String name;

    @Value("${value.lastname}")
    private String lastname;

    @Value("${value.random}")
    private String random;

    @Bean
    public MyBeanWithProperties func() {
        return new MyBeanWithPropertiesImplement(this.name, this.lastname);
    }
}
