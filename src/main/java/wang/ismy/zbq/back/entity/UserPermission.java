package wang.ismy.zbq.back.entity;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_user_permission")
public class UserPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userPermissionId;

    private Boolean login = true; // 登录权限

    private Boolean contentPublish =false;/* 内容发布权限 */;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public Integer getUserPermissionId() {
        return userPermissionId;
    }

    public void setUserPermissionId(Integer userPermissionId) {
        this.userPermissionId = userPermissionId;
    }

    public Boolean getLogin() {
        return login;
    }

    public void setLogin(Boolean login) {
        this.login = login;
    }

    public Boolean getContentPublish() {
        return contentPublish;
    }

    public void setContentPublish(Boolean contentPublish) {
        this.contentPublish = contentPublish;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
