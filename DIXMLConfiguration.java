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
		Doctor doc  = context.getBean(Doctor.class);
    Nurse nus = (Nurse) context.getBean("nurse");
		doc.assist();	
    nus.assist();
		}

}

//Under resources create spring.xml file
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id ="doctor" class="com.example1.dependencyinjection.Doctor"></bean>
    <bean id ="nurse" class="com.example1.dependencyinjection.Nurse"></bean>
</beans>

  //Doctor.java
  package com.example1.dependencyinjection;

public class Doctor {
	public void assist() {
		System.out.println("Assisting");
	}
}

//pom.xml
//Add
<dependency>
        	<groupId>org.springframework</groupId>
        	<artifactId>spring-context</artifactId>
        	<version>6.2.8</version>
    	</dependency>

  //Nurse.java
  package com.example1.dependencyinjection;

public class Nurse {
	public void assist() {
		System.out.println("Nurse is Assisting");
	}
}
