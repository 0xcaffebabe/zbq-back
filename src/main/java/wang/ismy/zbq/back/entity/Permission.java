package wang.ismy.zbq.back.entity;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Permission {

    private Integer permissionId;

    private String contentPublish /* 内容发布权限 */;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
