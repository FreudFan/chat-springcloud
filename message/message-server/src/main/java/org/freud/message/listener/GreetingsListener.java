package org.freud.message.listener;

import lombok.extern.slf4j.Slf4j;
import org.freud.message.dto.Greetings;
import org.freud.message.stream.GreetingsStreams;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GreetingsListener {

    @StreamListener(GreetingsStreams.INPUT)
    public void handleGreetings(@Payload Greetings greetings) {
        log.info("Received greetings: {}", greetings);
    }

}
