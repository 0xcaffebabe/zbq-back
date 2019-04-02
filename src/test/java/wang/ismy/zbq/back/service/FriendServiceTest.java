package wang.ismy.zbq.back.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FriendServiceTest {

    @Autowired
    FriendService friendService;


    @Test
    public void testSelect(){
        var list = friendService.findAll(PageRequest.of(0,20),"");
        assertEquals(20,list.size());

        assertEquals(Integer.valueOf(1),list.get(0).getUserId());
    }
}