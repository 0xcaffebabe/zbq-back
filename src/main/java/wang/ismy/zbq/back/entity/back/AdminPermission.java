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

    private Boolean login = true; // 登录权限

    private Boolean createAdmin = false; // 创建其他管理员的权限

    private Boolean dashboardView = false; // 查看仪表盘数据权限

    private Boolean userDataView = false; // 查看用户数据的权限

    private Boolean updateUser = false; // 更新用户数据的权限

    private Boolean friendView = false; // 查看好友关系的权限

    private Boolean stateView = false; // 查看动态的权限

    private Boolean locationView = false; // 查看位置的权限
}
