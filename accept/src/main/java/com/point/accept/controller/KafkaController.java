package com.point.accept.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huixing
 * @description Kafka控制层
 * @date 2019/10/29
 */
@Controller
@Slf4j
public class KafkaController {

    @RequestMapping("/")
    public String send(){

        return "";
    }

}
