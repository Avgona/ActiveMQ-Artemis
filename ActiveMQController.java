package com.avgona.activemq.controller;

import com.avgona.activemq.config.ActiveMQConfig;
import com.avgona.activemq.entity.MRP;
import com.avgona.activemq.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/active")
class ActiveMQController {

    private final JmsTemplate jmsTemplate;

    @Autowired
    ActiveMQController(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @GetMapping(value = "/send/{msg}", produces = "text/html")
    public String sendMsg(@PathVariable("msg") String msg){

        jmsTemplate.convertAndSend(ActiveMQConfig.PEOPLE_QUEUE, new Person("Vlad", "Parkh"));
        jmsTemplate.convertAndSend(ActiveMQConfig.MRP_QUEUE, new MRP("some-field1", "some-field2"));
        jmsTemplate.convertAndSend(ActiveMQConfig.MESSAGE_QUEUE, msg);

        return "done " + msg;
    }
}
