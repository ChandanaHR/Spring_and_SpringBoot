//Core Annotations
@Component
  Marks a class as a generic Spring-managed bean.
//Demo4Application.java
  package com.example4.demo4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo4Application implements CommandLineRunner {
	
	@Autowired
	private Component1 component1;

	public static void main(String[] args) {
		SpringApplication.run(Demo4Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		component1.start();
	}

}
//Component1.java
package com.example4.demo4;

import org.springframework.stereotype.Component;

@Component
public class Component1 {
	public void start() {
		System.out.println("Component has been started");
	}
}
Spring will automatically detect this bean when component scanning is enabled.
