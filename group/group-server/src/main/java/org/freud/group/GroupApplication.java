package org.freud.group;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.freud.file.client.mq.FileStreamSource;
import org.freud.message.client.MessageStreamSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableApolloConfig
@EnableBinding({FileStreamSource.class, MessageStreamSource.class})
@EnableFeignClients(basePackages = {"org.freud.user.client", "org.freud.file.client"})
@EnableEurekaClient
@EnableJpaAuditing
@SpringBootApplication
@ComponentScan(basePackages = "org.freud")
@MapperScan("org.freud.group.dao")
public class GroupApplication {

    public static void main(String[] args) {
        SpringApplication.run(GroupApplication.class, args);
    }

}
