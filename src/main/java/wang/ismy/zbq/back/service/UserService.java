package wang.ismy.zbq.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.ismy.zbq.back.dao.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public long countUser(){
        return userRepository.count();
    }

    public long countTodayLoginUser(){
        return userRepository.countTodayLoginUser();
    }
}
