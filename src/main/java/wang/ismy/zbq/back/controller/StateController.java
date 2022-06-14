package wang.ismy.zbq.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wang.ismy.zbq.back.annotations.MustLogin;
import wang.ismy.zbq.back.annotations.ResultTarget;
import wang.ismy.zbq.back.service.StateService;

@RestController
@RequestMapping("/state")
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping("/list")
    @ResultTarget
    @MustLogin
    public Object list(@RequestParam("page") Integer page,@RequestParam("length") Integer length){
        Pageable pageable = PageRequest.of(page,length);
        return stateService.findAll(pageable,"");
    }
}
