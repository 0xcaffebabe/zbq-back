package wang.ismy.zbq.back.dao;

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
}