package wang.ismy.zbq.back.entity.back;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer adminId;

    private String username;

    private String password;

    private String email;

    private Integer adminPermission;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private LocalDateTime lastLoginTime;


}
