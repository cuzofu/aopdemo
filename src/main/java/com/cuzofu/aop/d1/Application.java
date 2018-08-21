package com.cuzofu.aop.d1;

import com.cuzofu.aop.d1.cglib.PersonCglib;
import com.cuzofu.aop.d1.common.PersonProxyFactory;
import com.cuzofu.aop.d1.service.Speakable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private final Speakable personSpring;

    @Autowired
    public Application(Speakable personSpring) {
        this.personSpring = personSpring;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            // spring aop
            System.out.println("****** spring aop ******");
            personSpring.sayHi();
            personSpring.sayBye();

            // jdk dynamic proxy
            System.out.println("******** jdk dynamic proxy ******** ");
            Speakable jdkProxy = PersonProxyFactory.newJdkProxy();
            jdkProxy.sayHi();
            jdkProxy.sayBye();

            // cglib dynamic proxy
            System.out.println("******** cglib dynamic proxy ********");
            PersonCglib cglibProxy = PersonProxyFactory.newCglibProxy();
            cglibProxy.sayHi();
            cglibProxy.sayBye();

            System.exit(0);
        };
    }
}
