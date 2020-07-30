package org.freud.file.client.mq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface FileStreamSource {
    String OUTPUT = "fileDeleteOutput";

    @Output(OUTPUT)
    MessageChannel output();
}
