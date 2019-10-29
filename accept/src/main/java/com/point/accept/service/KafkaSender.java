package com.point.accept.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.point.accept.bean.AcceptBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.Date;
import java.util.UUID;

/**
 * @author huixing
 * @description kafka生产者
 * @date 2019/10/29
 */
@Component
@Slf4j
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    //发送消息方法
    public void send(AcceptBean accptBean) {
        log.info("+++++++++++++++++++++  message = {}", gson.toJson(accptBean));

        ListenableFuture<SendResult<String, String>> feature = kafkaTemplate.send("pic", gson.toJson(accptBean));

        feature.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.info("照片数据放入kafka失败");
            }

            @Override
            public void onSuccess(SendResult<String, String> stringStringSendResult) {
                log.info("照片数据放入kafka成功");
            }
        });

//                kafkaTemplate.send("zhisheng", gson.toJson(accptBean));
    }
}

