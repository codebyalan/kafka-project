package com.ambro.kafka.producer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaProducerService {

    @Value("${topic}")
    String topic;

    private KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
//        String topic = "javatechie-topic2";

        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("java-top",message);
        future.whenComplete((result,ex)->{
            if(ex == null){
                System.out.println("Sent message=["+message+"] with offset=["+result.getRecordMetadata().offset()+"]");
            }else{
                System.out.println("Unable to Sent message=[" + ex.getMessage() + "]");
            }
        });

    }

}
