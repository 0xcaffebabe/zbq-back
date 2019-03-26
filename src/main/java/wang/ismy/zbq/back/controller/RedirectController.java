package wang.ismy.zbq.back.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import wang.ismy.zbq.back.annotations.ErrorPage;
import wang.ismy.zbq.back.annotations.MustLogin;

@Controller
public class RedirectController {

    @RequestMapping("/login")
    public Object login(){
        return "login";
    }

    @RequestMapping("/main")
    @MustLogin
    @ErrorPage
    public Object main(){
        return "main";
    }

    @RequestMapping("/dashboard")
    @MustLogin
    @ErrorPage
    public Object dashboard(){
        return "dashboard";
    }
}
