package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mq")
public class MqTestController {

    /*@Autowired
    private JmsTemplate jmsTemplate;

    @RequestMapping("send")
    @ResponseBody
    public String sendMsg(String msg){
        jmsTemplate.convertAndSend(new ActiveMQQueue("p2p"),msg);
        return "success";
    }

    @JmsListener(destination = "p2p")
    public void listenMsg(String msg){
        System.out.println("-----p2p msg: "+msg);

    }
*/
}
