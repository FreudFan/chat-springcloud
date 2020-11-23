# Chat-SpringCloud
### 项目介绍 

基于Spring Cloud实现的基于Web的为微服务聊天系统。

本项目基于 [FreudFan/chat](https://github.com/FreudFan/chat) 项目开发。在原有基础上架构升级为了Spring Cloud体系，将服务进行了拆分，支持分布式微服务。

### 项目源码

|                   | github                                                       |
| ----------------- | ------------------------------------------------------------ |
| Spring Cloud 版本 | https://github.com/FreudFan/chat-springcloud                 |
| Spring Boot 版本  | https://github.com/FreudFan/chat                             |
| vue 前端          | https://github.com/FreudFan/chat/tree/master/chat_frontend_vue |

### 模块介绍

| 服务                 | 服务名      |
| :------------------- | :---------- |
| 注册中心             | eureka      |
| API网关              | api-gateway |
| 用户服务             | user        |
| 群组服务             | group       |
| socket通讯、消息服务 | message     |
| 文件服务             | file        |

### 技术栈

| 技术                           | 名称                        | 官网                                                   |
| ------------------------------ | --------------------------- | ------------------------------------------------------ |
| Spring Cloud                   | 分布式微服务框架            | https://projects.spring.io/spring-cloud                |
| Spring Boot                    | 快速应用开发Spring框架      | https://spring.io/projects/spring-boot                 |
| Netty                          | NIO框架                     | https://github.com/netty/netty                         |
| Spring session                 | 分布式Session管理           | http://projects.spring.io/spring-session               |
| Spring Data JPA                | ORM框架（基于hibernate）    | https://spring.io/projects/spring-data-jpa             |
| MyBatis                        | ORM框架                     | http://www.mybatis.org/mybatis-3/zh/index.html         |
| pagehelper-spring-boot-starter | MyBatis物理分页插件         | https://github.com/pagehelper/pagehelper-spring-boot   |
| Druid                          | 数据库连接池                | https://github.com/alibaba/druid                       |
| Redis                          | 分布式缓存数据库            | https://redis.io                                       |
| Kafka                          | 消息中间件                  | http://kafka.apache.org                                |
| Apollo                         | 分布式配置中心              | https://github.com/ctripcorp/apollo                    |
| Eureka                         | 服务发现框架                | https://github.com/Netflix/eureka                      |
| OpenFeign                      | 远程RPC调用框架             | https://github.com/spring-cloud/spring-cloud-openfeign |
| Feign-form                     | Feign远程传输二进制文件工具 | https://github.com/OpenFeign/feign-form                |
| Zuul                           | API网关框架                 | https://github.com/Netflix/zuul                        |
| Hystrix                        | 容错框架                    | https://github.com/Netflix/Hystrix                     |
| Maven                          | 项目构建管理                | http://maven.apache.org                                |

