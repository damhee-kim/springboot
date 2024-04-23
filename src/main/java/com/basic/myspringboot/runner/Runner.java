package com.basic.myspringboot.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.basic.myspringboot.vo.CustomerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@Component
@Order (2)
public class Runner implements ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(Runner.class);

    @Value("${myboot.name}")
    private String name;
    @Value("${myboot.age}")
    private int age;

    @Autowired
    private Environment enviroment;

    @Autowired
    private CustomerVO customer;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("MyRunner class");

        logger.info("현재 활성화된 profile = " + customer);

        logger.info("환경변수 myboot.name = " + name);
        logger.info("환경변수 myboot.age = " + age);

        logger.info("Enviroment 구현객체 클래스 이름 = " + enviroment.getClass().getName());

        logger.info("VM arguments -Dfoo " + args.containsOption("foo"));
        logger.info("VM arguments --bar " + args.containsOption("bar"));
    }
}
