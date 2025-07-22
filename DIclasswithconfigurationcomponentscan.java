//Injecting beans through Configuration annotation by Scanning Component (ComponentScan)
//Main.java
package com.example1.dependencyinjection;

import org.springframework.core.SpringVersion;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Spring version:" +SpringVersion.getVersion());
		//ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(Beanconfig.class);
		Doctor doc = context.getBean(Doctor.class);
		doc.assist();
		}

}
//Beanconfig.java
package com.example1.dependencyinjection;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.example1")
public class Beanconfig {

}
//Doctor.java
package com.example1.dependencyinjection;

import org.springframework.stereotype.Component;

@Component
public class Doctor implements Staff {

	public void assist() {
		System.out.println("Doctor is Assisting");
	}
}
//Nurse.java
package com.example1.dependencyinjection;

import org.springframework.stereotype.Component;

@Component
public class Nurse implements Staff {
	public void assist() {
		System.out.println("Nurse is Assisting");
	}
}


//Dependency injection through beanconfig.java class by Configuration annotation by creating beans through Bean annotation in beanconfig.java class
//Main.java
package com.example1.dependencyinjection;

import org.springframework.stereotype.Component;

@Component
public class Nurse implements Staff {
	public void assist() {
		System.out.println("Nurse is Assisting");
	}
}


//Doctor.java
package com.example1.dependencyinjection;

import org.springframework.stereotype.Component;

public class Doctor implements Staff {

	public void assist() {
		System.out.println("Doctor is Assisting");
	}
}

//Beanconfig.java
package com.example1.dependencyinjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.example1")
public class Beanconfig {
	@Bean
	public Doctor doctor() {
		return new Doctor();
	}
}
