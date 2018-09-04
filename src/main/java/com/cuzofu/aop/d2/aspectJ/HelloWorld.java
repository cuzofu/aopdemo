package com.cuzofu.aop.d2.aspectJ;

public class HelloWorld {

    private void sayHello() {
        System.out.println("hello aspectJ");
    }

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.sayHello();
    }
}
