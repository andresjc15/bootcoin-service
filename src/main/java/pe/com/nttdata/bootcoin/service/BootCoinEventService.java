package pe.com.nttdata.bootcoin.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import pe.com.nttdata.bootcoin.event.BootCoinCreatedEvent;
import pe.com.nttdata.bootcoin.event.Event;
import pe.com.nttdata.bootcoin.event.EventType;
import pe.com.nttdata.bootcoin.model.document.BootCoin;

import java.util.Date;
import java.util.UUID;

@Slf4j
@Service
public class BootCoinEventService {

    @Autowired
    private KafkaTemplate<String, Event<?>> producer;

    @Value("${topic.movement.name}")
    private String topicMovement;

    public void publish(BootCoin bootCoin) {
        BootCoinCreatedEvent created = new BootCoinCreatedEvent();
        created.setData(bootCoin);
        created.setId(UUID.randomUUID().toString());
        created.setType(EventType.CREATED);
        created.setDate(new Date());

        this.producer.send(topicMovement, created);
        log.info("[EVENT SAVED SUCCESSFULLY]: " + created.getData());
    }

}
