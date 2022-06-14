package wang.ismy.zbq.back.enums;

public enum PermissionEnum {

    LOGIN("login"), // 登录权限
    CREATE_ADMIN("createAdmin"), // 创建其他管理员的权限
    DASHBOARD_VIEW("dashboardView"), // 查看仪表盘数据的权限
    USER_DATA_VIEW("userDataView"), // 查看用户数据的权限
    UPDATE_USER("updateUser"), // 更新用户的权限
    FRIEND_VIEW("friendView"), // 查看好友关系的权限
    STATE_VIEW("stateView"), // 查看动态的权限
    LOCATION_VIEW("locationView"), // 查看位置的权限
    ;
    private String permission;

    PermissionEnum(String permission) {
        this.permission = permission;

    }

    public String getPermission() {
        return permission;
    }
}
