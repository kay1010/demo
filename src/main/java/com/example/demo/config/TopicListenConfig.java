package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import javax.jms.ConnectionFactory;

@Configuration
public class TopicListenConfig {

    @Bean
    public JmsListenerContainerFactory<DefaultMessageListenerContainer> topListenFactory(ConnectionFactory connectionFactory){
        DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory=new DefaultJmsListenerContainerFactory();
        defaultJmsListenerContainerFactory.setPubSubDomain(true);
        defaultJmsListenerContainerFactory.setConnectionFactory(connectionFactory);
        return  defaultJmsListenerContainerFactory;

    }
}
