package com.cjs.boot.handler;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ProgressBarHandler extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        for (int i = 1; i <= 100; i++) {
            Thread.sleep(200);
            session.sendMessage(new TextMessage(String.valueOf(i)));
        }


    }
}
