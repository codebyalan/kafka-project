package com.ambro.kafka.producer.controller;

import com.ambro.kafka.producer.service.KafkaProducerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class EventController {

    private static Logger logger = LogManager.getLogger(EventController.class);

    KafkaProducerService producerService;

    public EventController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping("send")
    public ResponseEntity<?> sendMessage(@RequestParam("msg") String msg){
        try {
            for(int i=0; i < 1000; i++)
                producerService.sendMessage("User : " + i);
            return ResponseEntity.ok("Sent successfully");
        }catch (Exception ex){
            logger.info(ex.getStackTrace());
            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
