//singleton bean scope
//Only one instance is created per Spring container.
//Same instance is returned on every getBean() call.
//Demo1Application.java
package com.example1.demo1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(ApplicationContext context) {
		return args -> {
			System.out.println("Getting Bean First time....");
			Singletonbean bean1 = context.getBean(Singletonbean.class);
			System.out.println("Getting Bean second time....");
			Singletonbean bean2 = context.getBean(Singletonbean.class);
			
		};
	}

}
//Singletonbean.java
package com.example1.demo1;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Singletonbean {
	public Singletonbean() {
		System.out.println("Sinlge ton bean is created");
	}
}
//Output
Singleton Bean Created appears only once
→ Confirms that Spring created only one instance of the bean.

✅ Both getBean() calls are made after that
→ Spring reuses the same instance for both calls.



  //Prototype bean:In Spring, a Prototype Bean is a bean that creates a new instance every time it is requested from the ApplicationContext.
  //Prototypebean.java
  package com.example1.demo1;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Prototypebean {
	public Prototypebean() {
		System.out.println("Prototype bean is created");
	}
}
//Demo1Application.java
package com.example1.demo1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo1(ApplicationContext context) {
		return args -> {
			System.out.println("Getting Bean First time....");
			Prototypebean bean1 = context.getBean(Prototypebean.class);
			System.out.println("Getting Bean second time....");
			Prototypebean bean2 = context.getBean(Prototypebean.class);
			
		};
	}

}


//Request bean scope
//It defines a new bean instance per HTTP request.
//Commonly used in web applications (e.g., tracking per-request data like IP, headers, user-agent, etc.).
//Scope only works if your app is a Spring Web/MVC app.
//Requestbean.java
package com.example1.demo1;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class Requestbean {
	public Requestbean() {
		System.out.println("Request bean scope is created");
	}
	public String getinfo() {
		return "I am chandana";
	}
}
//Mycontrollerrequest.java
package com.example1.demo1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class Mycontrollerrequest {
	@Autowired
	private ObjectFactory<Requestbean> requestbean;
	@GetMapping("/check-request")
	public String GetRequestscopedbean() {
		Requestbean rb = requestbean.getObject();
		return rb.getinfo();
	}
}
//Demo1Application.java
package com.example1.demo1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

}
Go to browser type http://localhost:8080/check-request
