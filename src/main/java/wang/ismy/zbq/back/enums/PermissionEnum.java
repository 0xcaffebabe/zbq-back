package wang.ismy.zbq.back.enums;

public enum PermissionEnum {

    LOGIN("login"), // 登录权限
    CREATE_ADMIN("createAdmin"), // 创建其他管理员的权限
    DASHBOARD_VIEW("dashboardView"), // 查看仪表盘数据的权限
    USER_DATA_VIEW("userDataView"), // 查看用户数据的权限
    ;
    private String permission;

    PermissionEnum(String permission) {
        this.permission = permission;

    }

    public String getPermission() {
        return permission;
    }
}
