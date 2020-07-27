package org.freud.group.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/***
 * 用户群
 */
@Data
@Entity(name = "user_group")
@EntityListeners(AuditingEntityListener.class)
public class Group implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /*** 群名称 **/
    @Column(nullable = false, unique = true)
    private String name;
    /*** 群主id **/
    @Column(nullable = false)
    private Integer masterId;
    /*** 群logo **/
    private Integer icon;
    /*** 群简介 **/
    private String info;
    /*** 是否可用 1:可用  0:不可用，群已被解散 **/
    private Integer flag;

    @CreatedDate
    private LocalDateTime createTime;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @LastModifiedDate
    private LocalDateTime updateTime;
}
