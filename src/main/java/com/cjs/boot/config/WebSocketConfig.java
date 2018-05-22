package com.cjs.boot.config;

import com.cjs.boot.handler.MyWebSocketHandler;
import com.cjs.boot.handler.ProgressBarHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(new MyWebSocketHandler(), "/myHandler");
        webSocketHandlerRegistry.addHandler(new ProgressBarHandler(), "/processBar");
    }
}
