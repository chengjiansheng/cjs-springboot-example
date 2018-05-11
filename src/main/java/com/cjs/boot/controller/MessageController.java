package com.cjs.boot.controller;

import com.cjs.boot.response.RespResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/message")
public class MessageController extends BaseController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @GetMapping("/add.html")
    public ModelAndView add() {
        return new ModelAndView("message/add");
    }

    @PostMapping("/send.json")
    @ResponseBody
    public RespResult send(String text) {
        ListenableFuture<SendResult<String, String>> result = kafkaTemplate.send("myTopic", String.valueOf(System.currentTimeMillis()), text);
        return RespResult.success();
    }

}
