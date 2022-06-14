package wang.ismy.zbq.back.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DashboardServiceTest {

    @Autowired
    DashboardService dashboardService;

    @Autowired
    AdminService adminService;

    @Test
    public void testD(){
        adminService.setCurrentAdmin(adminService.findById(1));
        System.out.println(dashboardService.getDashboard());
    }
}