package org.freud.message.mq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MessageStreamSink {
    String TO_USER = "messageToUserInput";
    String TO_GROUP = "messageToGroupInput";

    @Input(TO_USER)
    SubscribableChannel sendMessageToUserInput();

    @Input(TO_GROUP)
    SubscribableChannel sendMessageToGroupInput();
}
