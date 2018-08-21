package com.cuzofu.aop.d1.spring;

import com.cuzofu.aop.d1.common.MonitorSession;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MonitorAdvice {

    @Pointcut(value = "execution(* com.cuzofu.aop.d1.service.Speakable.*(..))")
    public void pointCut() {}

    @Around(value = "pointCut()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        MonitorSession.begin(pjp.getSignature().getName());
        pjp.proceed();
        MonitorSession.end();
    }

}
