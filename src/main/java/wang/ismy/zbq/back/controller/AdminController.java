package wang.ismy.zbq.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.ismy.zbq.back.annotations.ResultTarget;
import wang.ismy.zbq.back.dto.LoginDTO;
import wang.ismy.zbq.back.service.AdminService;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    @ResultTarget
    public Object login(@RequestBody @Valid LoginDTO loginDTO){
        adminService.login(loginDTO);
        return "登录成功";
    }
}
