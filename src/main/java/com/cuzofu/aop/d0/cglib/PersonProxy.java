package com.cuzofu.aop.d0.cglib;

import com.cuzofu.aop.d0.Person;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.logging.Logger;

public class PersonProxy implements MethodInterceptor {

    private Object delegate;
    private final static Logger logger = Logger.getLogger("PersonProxy");

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        logger.info("Before Proxy");
        Object result = methodProxy.invokeSuper(o, args);
        logger.info("After Proxy");
        return result;
    }

    public static Person getProxyInstance() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Person.class);
        enhancer.setCallback(new PersonProxy());
        return (Person) enhancer.create();
    }

    public static void main(String[] args) {
        PersonProxy.getProxyInstance().doSomething();
    }
}
