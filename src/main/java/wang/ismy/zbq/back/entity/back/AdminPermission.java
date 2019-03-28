package wang.ismy.zbq.back.entity.back;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_admin_permission")
public class AdminPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer permissionId;

    private Boolean login; // 登录权限

    private Boolean createAdmin; // 创建其他管理员的权限

    private Boolean dashboardView; // 查看仪表盘数据权限

    private Boolean userDataView; // 查看用户数据的权限
}
