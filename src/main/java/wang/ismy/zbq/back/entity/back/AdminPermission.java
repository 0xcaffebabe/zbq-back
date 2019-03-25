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

    private Boolean login;
}
