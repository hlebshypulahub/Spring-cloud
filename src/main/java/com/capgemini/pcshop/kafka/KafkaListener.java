package com.capgemini.pcshop.kafka;

import org.springframework.stereotype.Component;

@Component
public class KafkaListener {

    @org.springframework.kafka.annotation.KafkaListener(
            topics = "pcshop",
            groupId = "dummy"
    )
    void listener(String data) {
        System.out.println("Received data: " + data);
    }
}
