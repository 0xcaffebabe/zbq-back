package wang.ismy.zbq.back.service;

import org.springframework.stereotype.Service;
import wang.ismy.zbq.back.annotations.Permission;
import wang.ismy.zbq.back.enums.PermissionEnum;

@Service
public class TestService {

    @Permission(value = PermissionEnum.LOGIN,msg = "没有创建其他管理的权限")
    public void test(){
        System.out.println("test被执行");
    }
}
