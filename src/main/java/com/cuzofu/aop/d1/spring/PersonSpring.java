package com.cuzofu.aop.d1.spring;

import com.cuzofu.aop.d1.service.Speakable;
import org.springframework.stereotype.Service;

@Service
public class PersonSpring implements Speakable {
    @Override
    public void sayHi() {
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hi!!!");
    }

    @Override
    public void sayBye() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Bye!!!");
    }
}
