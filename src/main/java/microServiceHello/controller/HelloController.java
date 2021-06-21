package microServiceHello.controller;

import microServiceHello.model.HelloEntity;
import microServiceHello.service.HelloEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    private KafkaTemplate<String, Long> kafkaTemplate;
    private HelloEntityService helloEntityService;

    @Autowired
    public void setKafkaTemplate(KafkaTemplate<String, Long> kafkaTemplate, HelloEntityService helloEntityService) {
        this.kafkaTemplate = kafkaTemplate;
        this.helloEntityService = helloEntityService;
    }

    @GetMapping
    public String sayHello() {
        String message = "Добрый день";
        HelloEntity hello = helloEntityService.getByIdName("hello");
        hello.setCount(hello.getCount() + 1L);
        helloEntityService.saveHello(hello);
        long count = hello.getCount();
        kafkaTemplate.send("hello", count);
        return message;
    }
}
