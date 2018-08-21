package com.cuzofu.aop.d1.common;

import com.cuzofu.aop.d1.cglib.CGLibProxy;
import com.cuzofu.aop.d1.cglib.PersonCglib;
import com.cuzofu.aop.d1.jdk.DynamicProxy;
import com.cuzofu.aop.d1.jdk.PersonJdk;
import com.cuzofu.aop.d1.service.Speakable;

public class PersonProxyFactory {
    public static Speakable newJdkProxy() {
        // 代理PersonJdk
        DynamicProxy dynamicProxy = new DynamicProxy(new PersonJdk());
        return dynamicProxy.getProxy();
    }

    public static PersonCglib newCglibProxy() {
        CGLibProxy cgLibProxy = CGLibProxy.getInstance();
        return cgLibProxy.getProxy(PersonCglib.class);
    }
}
