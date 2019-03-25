package wang.ismy.zbq.back.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {

    @RequestMapping("/login")
    public Object login(){
        return "login";
    }
}
