package wang.ismy.zbq.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import wang.ismy.zbq.back.annotations.MustLogin;
import wang.ismy.zbq.back.annotations.ResultTarget;
import wang.ismy.zbq.back.service.UserInfoService;
import wang.ismy.zbq.back.service.UserPermissionService;
import wang.ismy.zbq.back.service.UserService;
import wang.ismy.zbq.back.vo.UserInfoVO;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserPermissionService userPermissionService;

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

    @GetMapping("/permission/{id}")
    @ResultTarget
    @MustLogin
    public Object permission(@PathVariable("id") Integer id){
        return userPermissionService.findByUserId(id);
    }

    @PostMapping("/info/{id}")
    @ResultTarget
    @MustLogin
    public Object updateUserInfo(@RequestBody @Valid UserInfoVO vo,@PathVariable("id") Integer userId){
        userService.update(vo,userId);

        return "更新成功";
    }
}
