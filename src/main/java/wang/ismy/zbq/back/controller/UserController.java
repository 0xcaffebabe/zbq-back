package wang.ismy.zbq.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import wang.ismy.zbq.back.annotations.MustLogin;
import wang.ismy.zbq.back.annotations.ResultTarget;
import wang.ismy.zbq.back.service.UserInfoService;
import wang.ismy.zbq.back.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/list")
    @ResultTarget
    @MustLogin
    public Object list(@RequestParam("page") Integer page,@RequestParam("length") Integer length,@RequestParam(value = "kw",required = false) String kw){
        if (StringUtils.isEmpty(kw)){
            return userService.findAll(page,length);
        }else{
            return userService.findAll(page,length,kw);
        }

    }

    @GetMapping("/info/{id}")
    @ResultTarget
    @MustLogin
    public Object info(@PathVariable("id") Integer id){
        return userInfoService.findByUserId(id);
    }
}
