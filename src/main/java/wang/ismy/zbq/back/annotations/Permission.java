package wang.ismy.zbq.back.annotations;

import wang.ismy.zbq.back.enums.PermissionEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
* 被该注释修饰的方法都会经过切面拦截校验权限
*/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Permission {
    PermissionEnum value();
    String msg() default "没有权限";
}
