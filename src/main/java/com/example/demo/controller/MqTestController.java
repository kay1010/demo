package com.example.demo.controller;


import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;

@Controller
@RequestMapping("mq")
public class MqTestController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @RequestMapping("p2p")
    @ResponseBody
    public String sendMsg_p2p(String msg){
        jmsTemplate.convertAndSend(new ActiveMQQueue("p2p"),msg);
        return "success";
    }

    @RequestMapping("topic")
    @ResponseBody
    public String sendMsg_topic(String msg){
        jmsTemplate.convertAndSend(new ActiveMQTopic("topic"),msg);
        return "success";
    }

  @JmsListener(destination = "p2p")
    public void listenMsg_p2p(String msg){
      System.out.println("-----p2p msg000000000000: "+msg);

    }
   @JmsListener(destination = "p2p")
    public void listenMsg_p2p1(String msg) throws InterruptedException {
       System.out.println("-----p2p msg0111111111111: "+msg);


    }
  @JmsListener(destination = "topic" ,containerFactory = "topListenFactory")
    public void listenTopicMsg(String msg){
        System.out.println("-----topic msg000000000000: "+msg);

    }
    @JmsListener(destination = "topic" ,containerFactory = "topListenFactory")
    public void listenTopicMsg1(String msg){
        System.out.println("-----topic msg11111111111: "+msg);

    }
    @JmsListener(destination = "topic" ,containerFactory = "topListenFactory")
    public void listenTopicMsg2(String msg){
        System.out.println("-----topic2 msg22222222: "+msg);

    }


}
