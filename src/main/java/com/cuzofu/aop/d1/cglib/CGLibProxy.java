package com.cuzofu.aop.d1.cglib;

import com.cuzofu.aop.d1.common.MonitorSession;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import javax.management.monitor.Monitor;
import java.lang.reflect.Method;

public class CGLibProxy implements MethodInterceptor {

    private static CGLibProxy instance = new CGLibProxy();

    private CGLibProxy() {
    }

    public static CGLibProxy getInstance() {
        return instance;
    }

    private Enhancer enhancer = new Enhancer();

    @SuppressWarnings("unchecked")
    public <T> T getProxy(Class<T> clazz) {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return (T) enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        MonitorSession.begin(method.getName());
        Object obj = methodProxy.invokeSuper(o, objects);
        MonitorSession.end();
        return obj;
    }
}
