//package com.ambro.kafka.producer.handler;
//
//import com.launchdarkly.eventsource.EventHandler;
//import com.launchdarkly.eventsource.MessageEvent;
//import org.springframework.kafka.core.KafkaTemplate;
//
//public class ChangeHandler {
//
//    private KafkaTemplate<String, String> kafkaTemplate;
//    private String topic;
//
//    public ChangeHandler(KafkaTemplate<String, String> kafkaTemplate, String topic) {
//        this.kafkaTemplate = kafkaTemplate;
//        this.topic = topic;
//    }
//
//    public void onMessage(String s, MessageEvent messageEvent){
//        kafkaTemplate.send(s,messageEvent.getData());
//    }
//
//}
