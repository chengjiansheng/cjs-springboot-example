package com.cjs.boot.service.impl;

import com.cjs.boot.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HelloServiceImpl implements HelloService {

    @Async
    @Override
    public void sayHello() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("123");
    }

    @Override
    public String sayHi(String name) {
        if ("xiao".equals(name)) {
            throw new IllegalArgumentException("你骗人");
        }

        return "Hi, " + name;
    }
}
