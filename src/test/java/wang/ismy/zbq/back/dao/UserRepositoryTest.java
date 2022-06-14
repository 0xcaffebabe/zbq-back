package wang.ismy.zbq.back.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {


    @Autowired
    UserRepository userRepository;


    @Test
    public void testCount(){
        assertEquals(52,userRepository.count());
    }


    @Test
    public void testToday(){
        assertEquals(2,userRepository.countTodayLoginUser());
    }
}