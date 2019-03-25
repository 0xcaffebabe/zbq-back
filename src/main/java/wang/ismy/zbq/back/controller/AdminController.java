package wang.ismy.zbq.back.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.ismy.zbq.back.annotations.ResultTarget;
import wang.ismy.zbq.back.dto.LoginDTO;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {


    @PostMapping("/login")
    @ResultTarget
    public Object login(@RequestBody @Valid LoginDTO loginDTO){

        System.out.println(loginDTO);
        return null;
    }
}
