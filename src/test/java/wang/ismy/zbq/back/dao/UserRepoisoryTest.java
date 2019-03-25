package wang.ismy.zbq.back.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wang.ismy.zbq.back.entity.User;

import java.util.Optional;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepoisoryTest {

    @Autowired
    UserRepository userRepository;


    @Test
    public void testSelect(){

        Optional<User> user = userRepository.findById(1);

        System.out.println(user);

    }
}