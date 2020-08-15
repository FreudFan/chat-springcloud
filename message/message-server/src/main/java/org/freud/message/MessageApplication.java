package org.freud.message;

import org.freud.message.mq.MessageStreamSink;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableBinding(MessageStreamSink.class)
@EnableFeignClients(basePackages = {"org.freud.group.client"})
@EnableEurekaClient
@EnableJpaAuditing
@ComponentScan(basePackages = "org.freud")
@MapperScan("org.freud.message.dao")
@SpringBootApplication
public class MessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageApplication.class, args);
    }

}
