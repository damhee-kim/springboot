package com.basic.myspringboot.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order (1)
public class Runner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("MyRunner class");
        System.out.println("VM arguments -Dfoo " + args.containsOption("foo"));
        System.out.println("VM arguments --bar " + args.containsOption("bar"));
    }
}
