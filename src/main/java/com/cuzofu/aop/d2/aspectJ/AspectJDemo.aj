package com.cuzofu.aop.d2.aspectJ;

public aspect AspectJDemo {

    pointcut recordLog():call(* HelloWorld.sayHello(..));

    pointcut authCheck():call(* HelloWorld.sayHello(..));

    before():authCheck() {
        System.out.println("sayHello方法执行前验证权限");
    }

    after():recordLog() {
        System.out.println("sayHello方法执行后记录日志");
    }
}
