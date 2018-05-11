package com.cjs.boot.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

@Data
public class BlackListEvent extends ApplicationEvent {

    private String address;

    public BlackListEvent(Object source, String address) {
        super(source);
        this.address = address;
    }
}
