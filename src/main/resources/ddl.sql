
# 创建管理员表
CREATE TABLE tb_admin(
  admin_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(255) NOT NULL ,
  password VARCHAR(255) NOT NULL ,
  email VARCHAR(255),
  admin_permission INT NOT NULL ,
  create_time DATETIME DEFAULT NOW(),
  update_time DATETIME,
  last_login_time DATETIME
)ENGINE=InnoDB CHARSET=utf8;

# 创建管理员权限表
CREATE TABLE tb_admin_permission(
  permission_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  login BOOLEAN DEFAULT TRUE COMMENT '登录权限',
  create_admin BOOLEAN DEFAULT FALSE COMMENT '创建其他管理员的权限',
  dashboard_view BOOLEAN DEFAULT TRUE NOT NULL COMMENT '查看仪表盘数据的权限',
  user_data_view BOOLEAN DEFAULT FALSE NOT NULL COMMENT '查看用户数据的权限',
  update_user BOOLEAN DEFAULT FALSE NOT NULL COMMENT '更新用户权限',
  friend_view BOOLEAN DEFAULT FALSE NOT NULL COMMENT '查看好友关系的权限',
  state_view BOOLEAN DEFAULT FALSE NOT NULL COMMENT '查看动态的权限',
  location_view BOOLEAN DEFAULT FALSE NOT NULL COMMENT '查看位置信息的权限'
)ENGINE=InnoDB CHARSET=utf8;

