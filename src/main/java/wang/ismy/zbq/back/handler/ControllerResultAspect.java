package wang.ismy.zbq.back.handler;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import wang.ismy.zbq.back.dto.Result;


@Aspect
@Component
public class ControllerResultAspect {

    @Pointcut("@annotation(wang.ismy.zbq.back.annotations.ResultTarget)")
    public void pointCut(){}

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Exception {

        try {
            Result result = new Result();
            result.setMsg("success");
            result.setData(joinPoint.proceed());
            result.setSuccess(true);
            return result;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg(throwable.getMessage());
            return result;
        }
    }
}
