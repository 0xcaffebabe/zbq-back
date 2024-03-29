package wang.ismy.zbq.back.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoServiceTest {

    @Autowired
    UserInfoService userInfoService;


    @Test
    public void testFind(){
        var info = userInfoService.findByUserId(1);
        assertEquals("root",info.getNickName());
    }
}