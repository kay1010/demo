package com.example.demo.websocket;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ServerEndpoint("/websocket/{name}")
public class WebSocket {

    //与某个客户端连接对话，通过此对客户端发送消息
    private Session session;

    //存放连接的session
    private static ConcurrentHashMap<String, WebSocket> webSocketConcurrentHashMap = new ConcurrentHashMap<>();

    //浏览器客户端连接成功时的回调方法
    @OnOpen
    public void onOpen(Session session, @PathParam(value = "name") String name){
        System.out.println("-----当前WebSocket实例为："+this);
        this.session = session;

        //如果这个名字（作为一个人的标识）已经有一个连接，断开原来的连接，建立新连接（可以理解为qq只能单终端登录）
        if(webSocketConcurrentHashMap.containsKey(name)){
            try {
                ((WebSocket)webSocketConcurrentHashMap.get(name)).session.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            webSocketConcurrentHashMap.remove(name);
            webSocketConcurrentHashMap.put(name,this);

        }else{
            webSocketConcurrentHashMap.put(name,this);
        }
        System.out.println(name+"成功连接webSocket，当前保持连接的人数为：" + webSocketConcurrentHashMap.size() + "人");
    }

    @OnClose
    public void onClose(){

        for(String name : webSocketConcurrentHashMap.keySet()){

            if(this == webSocketConcurrentHashMap.get(name)){

                webSocketConcurrentHashMap.remove(name);
                System.out.println(name+"退出websocket连接，当前连接人数为：" + webSocketConcurrentHashMap.size());
                break;
            }
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable){

        System.out.println("error:");
        throwable.printStackTrace();
    }

    @OnMessage
    public void onMessage( String message){

        System.out.println("webSocket服务端接收到消息内容为：" + message);

        //群发消息
        for(String name : webSocketConcurrentHashMap.keySet()){
            try {
                if(this.session == webSocketConcurrentHashMap.get(name).session)//消息发送给除发送人之外的连接者
                    continue;

                webSocketConcurrentHashMap.get(name).session.getBasicRemote().sendText("来自"+name + "的消息:" +message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}