package service.serviceImpl;

import api.Response;
import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
@Component
@Aspect
public class CheckLoginAOP {
    @Autowired
    private HttpSession httpSession;

    @Pointcut("execution(* controller.*.*(..))&&!execution(* controller.*.Login(..))&&!execution(* controller.*.amdinLogin(..))"+
            "&&!execution(* controller.*.SearchBar(..))&&!execution(* controller.*.AnnoInfo(..))&&!execution(* controller.*.FindAllInaBook(..))"+
            "&&!execution(* controller.*.register(..))")
    public void pointCut(){}
    @Around("pointCut()")
    public Object doCheck(ProceedingJoinPoint proceedingJoinPoint) {
        Object object = "";
        try{
            String username = (String) httpSession.getAttribute("name");
            if(username == null || "".equals(username)){
                object = JSON.toJSONString(new Response("未登录",0));
            }else {
                object = proceedingJoinPoint.proceed();
            }
        }catch (Exception e){
            object = JSON.toJSONString(new Response("未登录",0));
        } catch (Throwable throwable) {
            object = JSON.toJSONString(new Response("未登录",0));
            throwable.printStackTrace();
        }
        return object;
    }
}
