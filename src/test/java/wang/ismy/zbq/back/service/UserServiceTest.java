package wang.ismy.zbq.back.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    AdminService adminService;

    @Test
    public void testPage(){
        var list = userService.findAll(0,5);
        assertEquals(5,list.size());
        System.out.println(list);
    }


    @Test
    public void testPage1(){
        adminService.setCurrentAdmin(adminService.findById(1));
        var list = userService.findAll(0,5,"2019");

        assertEquals(5,list.size());

        System.out.println(list);
    }


    @Test()
    public void testUpdate(){
        var user = userService.findById(55);

        user.setUsername("2019032901");

        userService.update(user);
    }
}