package wang.ismy.zbq.back.entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_user_permission")
@Data
public class UserPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userPermissionId;


    private Boolean login = true; // 登录权限

    private Boolean contentPublish =false;/* 内容发布权限 */;

    public Boolean coursePublish = false;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;




}
