package wang.ismy.zbq.back.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.ismy.zbq.back.annotations.Permission;
import wang.ismy.zbq.back.dao.UserInfoRepository;
import wang.ismy.zbq.back.entity.UserInfo;
import wang.ismy.zbq.back.enums.PermissionEnum;
import wang.ismy.zbq.back.uti.ErrorUtils;
import wang.ismy.zbq.back.uti.R;
import wang.ismy.zbq.back.vo.UserInfoVO;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private UserService userService;

    @Permission(PermissionEnum.USER_DATA_VIEW)
    public UserInfoVO findByUserId(Integer userId) {
        var user = userService.findById(userId);

        if (user != null) {
            var userInfo = userInfoRepository.findById(user.getUserInfo()).get();
            UserInfoVO vo = new UserInfoVO();
            if (userInfo != null){
                vo.setUsername(user.getUsername());
                vo.setPassword(user.getPassword());
                BeanUtils.copyProperties(userInfo,vo);
            }
            return vo;
        }
        ErrorUtils.error(R.CAN_NOT_FOUND);
        return null;
    }

    public UserInfo findByUserInfoId(Integer userInfoId){
        return userInfoRepository.findById(userInfoId).get();
    }

    public UserInfo update(UserInfo userInfo){
        return userInfoRepository.save(userInfo);
    }
}
