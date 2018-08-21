package com.cuzofu.aop.d0.dynamic;

import com.cuzofu.aop.d0.IPerson;
import com.cuzofu.aop.d0.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Logger;

public class PersonProxy implements InvocationHandler {

    private Object delegate;

    private final static Logger logger = Logger.getLogger("PersonProxy");

    public Object bind(Object delegate) {
        this.delegate = delegate;
        return Proxy.newProxyInstance(
                delegate.getClass().getClassLoader(),
                delegate.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        logger.info("Before Proxy");
        result = method.invoke(delegate, args);
        logger.info("After Proxy");
        return result;
    }

    public static void main(String[] args) {
        PersonProxy personProxy = new PersonProxy();
        IPerson iPerson = (IPerson) personProxy.bind(new Person());
        iPerson.doSomething();
    }
}
