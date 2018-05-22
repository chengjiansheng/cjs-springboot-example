package com.cjs.boot.handler;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MyWebSocketHandler extends TextWebSocketHandler {

    /**
     * WebSocketSession用于服务端向客户端发送消息
     * TextMessage为服务端接收到的客户端发送的消息
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println(message);

        String result = "Hello WebSocket";
        String msg = message.getPayload();
        switch (msg) {
            case "1":
               result = "西瓜汁";
               break;
            case "2":
                result = "柚子茶";
                break;
            case "3":
                result = "芒果汁";
                break;
            case "4":
                result = "橙汁";
                break;
        }
        session.sendMessage(new TextMessage(result));
    }
}
