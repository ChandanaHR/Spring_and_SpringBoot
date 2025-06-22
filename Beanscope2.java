//Session scope
//@SessionScope means Spring will create one bean instance per HTTP session.
//This is useful for storing user-specific data that should persist across multiple requests during the session (e.g., shopping cart, login info).
//Sessionbean.java
package com.example1.demo1;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Sessionbean {
	int session = 0;
	public Sessionbean() {
		System.out.println("Session bean created");
	}
	public int getsession() {
		return session++;
	}
}
//Mycontroller1.java
package com.example1.demo1;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class Mycontroller1 {
	@Autowired
	private ObjectFactory<Sessionbean> sessionbean;
	@GetMapping("/visit")
	public int getsessionbeanvalue() {
		Sessionbean sb = sessionbean.getObject();
		return sb.getsession();
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



//Applicationbeanscope
//application scope means one instance per ServletContext.
//This bean is shared across all HTTP requests and sessions.
//It lives as long as the application is running.
//Applicationbean.java
package com.example1.demo1;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(WebApplicationContext.SCOPE_APPLICATION)
public class Applicationbean {
	public Applicationbean() {
		System.out.println("Application bean created");
	}
	public String getmessage() {
		return "Welcome to Spring tut";
	}
}
//Mycontroller2.java
package com.example1.demo1;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mycontroller2 {
	@Autowired
	private ObjectFactory<Applicationbean> applicationbean;
	@GetMapping("/message") 
	public String getmessage1() {
		Applicationbean ab1 = applicationbean.getObject();
		return ab1.getmessage();
	}
}

