package com.basic.myspringboot;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import java.util.function.Consumer;

@SpringBootApplication
public class BasicSpringBootAppApplication {

	public static void main(String[] args) {

		// SpringApplication.run(BasicSpringBootAppApplication.class, args);

		SpringApplication springApplication = new SpringApplication(BasicSpringBootAppApplication.class);
		springApplication.setWebApplicationType(WebApplicationType.SERVLET);
		springApplication.run(args);
	}

	@Bean
	@Order(2)
	public ApplicationRunner applicationRunner() {

		// 1. Anoymous Inner class
		 return new ApplicationRunner() {
			 @Override
			 public void run(ApplicationArguments args) throws Exception {
				 System.out.println("Anonymous Inner class 형태");

				 args.getOptionNames().forEach(new Consumer<String>() {
					 @Override
					 public void accept(String name) {
						 System.out.println("argument name = " + name);
					 }
				 });

			 }
		 };
	}

	@Bean
	@Order(3)
	public ApplicationRunner applicationbRunnerLamda() {

		return args -> {
			System.out.println("Lamda Expression 형태");
			args.getOptionNames().forEach(name -> System.out.println("None Option : Name = " + name));
		};
	}

}
