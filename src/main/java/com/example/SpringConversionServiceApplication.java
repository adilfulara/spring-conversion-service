package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

@SpringBootApplication
public class SpringConversionServiceApplication {

    private static Logger LOG = LoggerFactory.getLogger(SpringConversionServiceApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringConversionServiceApplication.class, args);
        LOG.info(context.getBean("family").toString());
    }

    @Bean
    public ConversionService conversionService(MyBeanConverter myBeanConverter) {
        DefaultConversionService service = new DefaultConversionService();
        service.addConverter(String.class, Person.class, myBeanConverter);
        return service;
    }
}
