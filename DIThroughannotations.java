//Injecting beans through annotations @Component
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

//spring.xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="
           http://www.springframework.org/schema/beans 
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/context 
           http://www.springframework.org/schema/context/spring-context.xsd">

    <!-- Scan the package for @Component classes -->
    <context:component-scan base-package="com.example1" />

</beans>

  //Main.java
  package com.example1.dependencyinjection;

import org.springframework.core.SpringVersion;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Spring version:" +SpringVersion.getVersion());
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Doctor doc = context.getBean(Doctor.class);
		doc.assist();
		}

}
