package com.cjs.boot.demo;

import com.cjs.boot.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asyncdemo")
public class AsyncDemo {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public String hello() {
        for (int i = 0; i < 20; i++) {
            helloService.sayHello();
        }
        System.out.println(456);
        return "world";
    }

}
