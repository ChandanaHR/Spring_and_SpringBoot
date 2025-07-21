//Dependency injection through XML Configuration by adding properties
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
		System.out.println(doc.getQualification());
		}

}

//Doctor.java
package com.example1.dependencyinjection;

public class Doctor implements Staff {
	private String qualification;
	
	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public void assist() {
		System.out.println("Doctor is Assisting");
	}
}
//spring.xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id ="doctor" class="com.example1.dependencyinjection.Doctor">
    	<property name="qualification" value="MBBS"></property>
    </bean>
    <bean id="nurse" class="com.example1.dependencyinjection.Nurse"></bean>

</beans>
