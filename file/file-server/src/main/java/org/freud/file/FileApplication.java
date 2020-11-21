package org.freud.file;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.freud.file.mq.FileStreamSink;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableApolloConfig
@EnableBinding(FileStreamSink.class)
@EnableEurekaClient
@EnableJpaAuditing
@SpringBootApplication
@ComponentScan(basePackages = "org.freud")
@MapperScan("org.freud.file.dao")
public class FileApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileApplication.class, args);
    }

}
