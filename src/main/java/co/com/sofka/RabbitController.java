package co.com.sofka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("test")
public class RabbitController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping
    public void testSendMessage(){
        String message = "Mensaje #" + ThreadLocalRandom.current().nextInt();
        this.publisherService.sendToRabbit(message);
    }
}
