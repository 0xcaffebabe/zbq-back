package wang.ismy.zbq.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.ismy.zbq.back.annotations.MustLogin;
import wang.ismy.zbq.back.annotations.ResultTarget;
import wang.ismy.zbq.back.service.DashboardService;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("")
    @MustLogin
    @ResultTarget
    public Object getDashboard(){
        return dashboardService.getDashboard();
    }
}
