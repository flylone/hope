//package com.wsq.hope.web.aop;
//
//import java.util.Date;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.stereotype.Component;
//import org.springframework.ui.ModelMap;
//
//@Component
//@Aspect
//public class LogConfig {
//
//    @Around("execution(* com.wsq.hope.web.controller.*.*(..))&&args(model,user,..)")
//    public Object addLogTime(ProceedingJoinPoint point, ModelMap model, String user) throws Throwable {
//        System.out.println(new Date());
//        Object result = point.proceed();
//        System.out.println(new Date());
//        return result;
//    }
//}
