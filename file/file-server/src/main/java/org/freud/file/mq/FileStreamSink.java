package org.freud.file.mq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface FileStreamSink {
    String INPUT = "fileDeleteInput";

    @Input(INPUT)
    SubscribableChannel input();
}
