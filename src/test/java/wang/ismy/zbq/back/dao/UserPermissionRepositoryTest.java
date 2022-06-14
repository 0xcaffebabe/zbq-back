package wang.ismy.zbq.back.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserPermissionRepositoryTest {

    @Autowired
    UserPermissionRepository userPermissionRepository;


    @Test
    public void testSelect(){
        var p = userPermissionRepository.findById(3);
        assertEquals(false,p.get().getLogin());
    }
}