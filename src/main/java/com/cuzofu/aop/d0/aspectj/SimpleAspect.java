package com.cuzofu.aop.d0.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SimpleAspect {

    @Pointcut("execution(* com.cuzofu.aop.d0.aspectj.*Service*.*(..))")
    public void pointCut() {
    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("after aspect execute");
    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("before aspect executing");
    }

    @AfterReturning(pointcut = "pointCut()", returning = "returnVal")
    public void afterReturning(JoinPoint joinPoint, Object returnVal) {
        System.out.println("afterReturning executed, return result is " + returnVal);
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println(" around start");
        try {
            pjp.proceed();
        } catch (Throwable throwable) {
            System.out.println("error is around");
            throw throwable;
        }
        System.out.println("around end");
    }

    @AfterThrowing(pointcut = "pointCut()", throwing = "error")
    public void afterThrowing(JoinPoint jp, Throwable error) {
        System.out.println("error: " + error);
    }
}
