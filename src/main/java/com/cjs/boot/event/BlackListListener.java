package com.cjs.boot.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BlackListListener implements ApplicationListener<BlackListEvent> {

    @Override
    public void onApplicationEvent(BlackListEvent event) {
        System.out.println("监听到BlackListEvent事件: " + event.getAddress());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @EventListener
    public void processBlackListEvent(BlackListEvent event) {
        System.out.println(123);
    }
}
