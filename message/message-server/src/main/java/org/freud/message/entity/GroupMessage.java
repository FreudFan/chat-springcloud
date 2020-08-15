package org.freud.message.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/***
 * 群聊天消息
 */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class GroupMessage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /*** 发送用户id */
    @Column(nullable = false)
    private Integer senderUserId;

    /*** 群id */
    @Column(nullable = false)
    private Integer groupId;

    /*** 消息 */
    @Column(nullable = false)
    private String message;

    @CreatedDate
    private LocalDateTime createTime;
}
