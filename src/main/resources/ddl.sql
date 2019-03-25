
# 创建管理员表
CREATE TABLE tb_admin(
  admin_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(255) NOT NULL ,
  password VARCHAR(255) NOT NULL ,
  email VARCHAR(255),
  admin_permission INT NOT NULL ,
  create_time DATETIME NOT NULL ,
  update_time DATETIME,
  last_login_time DATETIME
)ENGINE=InnoDB CHARSET=utf8;

# 创建管理员权限表
CREATE TABLE tb_admin_permission(
  permission_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  login BOOLEAN DEFAULT TRUE COMMENT '登录权限'
)

