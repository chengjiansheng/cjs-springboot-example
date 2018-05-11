package com.cjs.boot.controller;

import com.cjs.boot.event.BlackListEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activity")
public class ActivityController {

//    @Autowired
//    private ApplicationEventPublisher publisher;

    @Autowired
    private ApplicationContext publisher;

    @GetMapping("/sayHello.json")
    public void sayHello() {

        /**
         * You may register as many event listeners as you wish, but note that by default event listeners receive events synchronously.
         * This means the publishEvent() method blocks until all listeners have finished processing the event.
         */

        BlackListEvent event = new BlackListEvent(this, "abc@126.com");
        publisher.publishEvent(event);
        System.out.println("事件发布成功");
    }

}
