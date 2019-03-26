package wang.ismy.zbq.back.service;



import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;
import wang.ismy.zbq.back.entity.back.Admin;

import java.security.NoSuchAlgorithmException;



@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceTest {

    @Autowired
    AdminService adminService;


    @Test
    public void testCreate() throws NoSuchAlgorithmException {

        Admin admin = new Admin();
        admin.setEmail("715711877@qq.com");
        admin.setUsername("my");
        admin.setPassword(DigestUtils.md5DigestAsHex("123".getBytes()));
        admin = adminService.createNewAdmin(admin);

        Assert.assertEquals(Integer.valueOf(1),admin.getAdminId());

    }


}