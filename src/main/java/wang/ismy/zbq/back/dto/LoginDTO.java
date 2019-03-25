package wang.ismy.zbq.back.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginDTO {

    @NotNull(message = "管理员账号不得为空")
    private String username;

    @NotNull(message = "密码不得为空")
    private String password;
}
