package wang.ismy.zbq.back.handler;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wang.ismy.zbq.back.service.AdminPermissionService;
import wang.ismy.zbq.back.annotations.Permission;
import wang.ismy.zbq.back.service.AdminService;
import wang.ismy.zbq.back.uti.ErrorUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Aspect
@Component
public class PermissionAspect {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminPermissionService adminPermissionService;

    @Pointcut("@annotation(wang.ismy.zbq.back.annotations.Permission)")
    public void pointCut(){}

    @Before("pointCut()")
    public void before(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        var a = method.getAnnotation(Permission.class);

        String msg = null;
        if ("".equals(a.msg())){
            msg = "没有"+a.value().getPermission()+"权限";
        }else{
            msg = a.msg();
        }
        var permission = adminPermissionService.getCurrentAdminPermission();

        try {
            String methodName = a.value().getPermission();
            methodName = methodName.substring(0,1).toUpperCase()+methodName.substring(1,methodName.length());
            Method method1 = permission.getClass().getMethod("get"+methodName);
            Boolean ret = (Boolean) method1.invoke(permission);
            if (ret == null){
                ErrorUtils.error(msg);
            }

            if (!ret){
                ErrorUtils.error(msg);
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e.getMessage()+","+msg);
        }

    }
}
