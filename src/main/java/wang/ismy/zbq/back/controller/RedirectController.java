package wang.ismy.zbq.back.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/manage/{url}")
    @MustLogin
    @ErrorPage
    public Object dashboard(@PathVariable("url") String url){
        return url;
    }

    @GetMapping("")
    public String home(){
        return "login";
    }

}
