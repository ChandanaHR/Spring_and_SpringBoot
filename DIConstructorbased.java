//Depenedency injection through constructor via XML Configuration
//spring.xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id ="doctor" class="com.example1.dependencyinjection.Doctor">
    	<constructor-arg value="MBBS"></constructor-arg>
    </bean>
    <bean id="nurse" class="com.example1.dependencyinjection.Nurse"></bean>

</beans>

  //Doctor.java
  package com.example1.dependencyinjection;

public class Doctor implements Staff {
	
	public Doctor(String qualification) {
		super();
		this.qualification = qualification;
	}

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
