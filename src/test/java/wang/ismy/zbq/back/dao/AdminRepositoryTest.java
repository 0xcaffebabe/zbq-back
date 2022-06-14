package wang.ismy.zbq.back.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wang.ismy.zbq.back.entity.back.Admin;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminRepositoryTest {

    @Autowired
    AdminRepository adminRepository;


    @Test
    public void testInsert(){

        Admin admin = new Admin();

    }


    @Test
    public void testSearch(){
        Admin admin = adminRepository.findByUsername("my");

        Assert.assertEquals("my",admin.getUsername());
    }


    @Test
    public void testLogin(){
        var admin = adminRepository.findByUsernameAndPassword("my1","08B00150023BCFE94746861E45385948");
        Assert.assertEquals("my", admin.getUsername());
    }
}