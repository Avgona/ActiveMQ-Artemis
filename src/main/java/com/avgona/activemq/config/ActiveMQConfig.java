package com.avgona.activemq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;


@EnableJms
@Configuration
public class ActiveMQConfig {

    public static final String MRP_QUEUE = "mrps";
    public static final String PEOPLE_QUEUE = "people";
    public static final String MESSAGE_QUEUE = "messages";

    @Bean
    public MessageConverter converter() {
        var converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_text");
        return converter;
    }
}
