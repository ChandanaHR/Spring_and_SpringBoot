//singleton
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
		doc.setQualification("MBBS");
		System.out.println(doc.getQualification());
		
		Doctor doc1 = context.getBean(Doctor.class);
		doc1.assist();
		System.out.println(doc1.getQualification());
		}

}

//Doctor.java
package com.example1.dependencyinjection;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope(scopeName = "singleton")
public class Doctor implements Staff {
	private String qualification;
	
	@Override
	public String toString() {
		return "Doctor [qualification=" + qualification + "]";
	}
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

//Beanconfig.java
package com.example1.dependencyinjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.example1")
public class Beanconfig {
}


//prototype
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
		doc.setQualification("MBBS");
		System.out.println(doc.getQualification());
		
		Doctor doc1 = context.getBean(Doctor.class);
		doc1.assist();
		System.out.println(doc1.getQualification());
		}

}
//Doctor.java
package com.example1.dependencyinjection;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope(scopeName = "prototype")
public class Doctor implements Staff {
	private String qualification;
	
	@Override
	public String toString() {
		return "Doctor [qualification=" + qualification + "]";
	}
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
//Beanconfig.java
package com.example1.dependencyinjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.example1")
public class Beanconfig {
}

