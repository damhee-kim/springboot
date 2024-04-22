package com.basic.myspringboot.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@Component
@Order (1)
public class Runner implements ApplicationRunner {
    @Value("${myboot.name}")
    private String name;
    @Value("${myboot.age}")
    private int age;

    @Autowired
    private Environment enviroment;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("MyRunner class");

        System.out.println("환경변수 myboot.name = " + name);
        System.out.println("환경변수 myboot.age = " + age);

        System.out.println("Enviroment 구현객체 클래스 이름 = " + enviroment.getClass().getName());

        System.out.println("VM arguments -Dfoo " + args.containsOption("foo"));
        System.out.println("VM arguments --bar " + args.containsOption("bar"));
    }
}
