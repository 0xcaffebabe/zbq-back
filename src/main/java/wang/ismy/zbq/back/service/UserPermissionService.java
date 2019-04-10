package wang.ismy.zbq.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitPostProcessor;
import org.springframework.stereotype.Service;
import wang.ismy.zbq.back.annotations.Permission;
import wang.ismy.zbq.back.dao.UserPermissionRepository;
import wang.ismy.zbq.back.entity.User;
import wang.ismy.zbq.back.entity.UserPermission;
import wang.ismy.zbq.back.enums.PermissionEnum;
import wang.ismy.zbq.back.uti.ErrorUtils;
import wang.ismy.zbq.back.uti.R;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserPermissionService {

    @Autowired
    private UserPermissionRepository userPermissionRepository;

    @Autowired
    private UserService userService;

    @Permission(PermissionEnum.USER_DATA_VIEW)
    public Map<String,Boolean> findByUserId(Integer userId){


        var user = userService.findById(userId);

        Map<String,Boolean> ret = new HashMap<>();
        if (user != null){
            var permission = userPermissionRepository.findById(user.getPermission()).get();
            var methods = permission.getClass().getMethods();
            for (var i : methods){
                if (i.getName().startsWith("get")){
                    if (i.getReturnType().equals(Boolean.class)){
                        try {
                            ret.put(i.getName().replace("get",""),(Boolean) i.invoke(permission));
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            throw new RuntimeException(e);
                        }

                    }
                }
            }
        }


        return ret;
    }

    @Permission(PermissionEnum.UPDATE_USER)
    public void updatePermission(Integer userId,Map<String,Boolean> map){
        User user = userService.findById(userId);
        if (user == null) ErrorUtils.error(R.USER_NOT_EXIST);

        UserPermission userPermission = userPermissionRepository.
                findById(user.getPermission()).orElse(new UserPermission());

        if (userPermission.getUserPermissionId() == null) ErrorUtils.error(R.UNKNOWN_ERROR);
        var methods = userPermission.getClass().getMethods();
        for (var key : map.keySet()){

            try {

                for (var i : methods){
                    if (i.getName().contains("set"+key)){
                        i.invoke(userPermission,map.get(key));
                    }
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }

        userPermissionRepository.save(userPermission);


    }
}
