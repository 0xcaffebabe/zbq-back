package wang.ismy.zbq.back.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wang.ismy.zbq.back.annotations.Permission;
import wang.ismy.zbq.back.dao.UserRepository;
import wang.ismy.zbq.back.entity.User;
import wang.ismy.zbq.back.entity.UserInfo;
import wang.ismy.zbq.back.enums.PermissionEnum;
import wang.ismy.zbq.back.uti.ErrorUtils;
import wang.ismy.zbq.back.uti.R;
import wang.ismy.zbq.back.vo.UserInfoVO;
import wang.ismy.zbq.back.vo.UserVO;

import javax.lang.model.type.ErrorType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserInfoService userInfoService;

    public long countUser(){
        return userRepository.count();
    }

    public long countTodayLoginUser(){
        return userRepository.countTodayLoginUser();
    }

    @Permission(PermissionEnum.USER_DATA_VIEW)
    public List<UserVO> findAll(Integer page,Integer length){
        Pageable pageable = PageRequest.of(page,length);
        Page<User> userPage = userRepository.findAll(pageable);

        List<UserVO> userVOList = new ArrayList<>();
        userPage.stream().forEach((e)->{
            UserVO vo = new UserVO();
            BeanUtils.copyProperties(e,vo);
            userVOList.add(vo);
        });
        return userVOList;
    }

    @Permission(PermissionEnum.USER_DATA_VIEW)
    public List<UserVO> findAll(Integer page,Integer length,String kw){
        Pageable pageable = PageRequest.of(page,length);
        Page<User> userPage = userRepository.findUserListByUsername(kw,pageable);
        List<UserVO> userVOList = new ArrayList<>();
        userPage.stream().forEach((e)->{
            UserVO vo = new UserVO();
            BeanUtils.copyProperties(e,vo);
            userVOList.add(vo);
        });
        return userVOList;
    }

    public User findById(Integer id){
        return userRepository.findById(id).get();
    }

    public User update(User user){
        return userRepository.save(user);
    }

    @Transactional
    @Permission(PermissionEnum.UPDATE_USER)
    public void update(UserInfoVO userInfoVO,Integer userId){
        var user = findById(userId);

        if (user == null) ErrorUtils.error(R.USER_NOT_EXIST);

        BeanUtils.copyProperties(userInfoVO,user);

        userRepository.save(user);

        var userInfo = userInfoService.findByUserInfoId(userId);
        BeanUtils.copyProperties(userInfoVO,userInfo);
        userInfoService.update(userInfo);
    }
}
