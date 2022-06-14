package wang.ismy.zbq.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.ismy.zbq.back.annotations.Permission;
import wang.ismy.zbq.back.dao.UserRepository;
import wang.ismy.zbq.back.dto.DashboardVO;
import wang.ismy.zbq.back.enums.PermissionEnum;

@Service
public class DashboardService {

    @Autowired
    private UserService userService;

    @Permission(value = PermissionEnum.DASHBOARD_VIEW,msg = "没有查看仪表盘数据的权限")
    public DashboardVO getDashboard(){
        Long totalUser = userService.countUser();
        Long todayUser = userService.countTodayLoginUser();
        DashboardVO vo = new DashboardVO();
        vo.setTotalUser(totalUser);
        vo.setTodayUser(todayUser);
        return vo;
    }
}
