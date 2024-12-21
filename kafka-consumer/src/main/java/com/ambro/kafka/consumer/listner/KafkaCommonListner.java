package com.ambro.kafka.consumer.listner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaCommonListner {

    @Value("${topic}")
    String topic;
    @Value("${group}")
    String group;

    Logger log = LogManager.getLogger(KafkaCommonListner.class);

    @KafkaListener(topics = "java-top",groupId = "java-group")
    public  void consume(String message) {
        log.info("Consume1 the mesaage {}" , message);
    }

    @KafkaListener(topics = "java-top",groupId = "java-group")
    public  void consume1(String message) {
        log.info("Consume2 the mesaage {}" , message);
    }

    @KafkaListener(topics = "java-top",groupId = "java-group")
    public  void consume2(String message) {
        log.info("Consume3 the mesaage {}" , message);
    }
}
