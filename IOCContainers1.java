//Application context
package com.example6.Applicationcontext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ApplicationcontextApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ApplicationcontextApplication.class, args);
		Student student1 = context.getBean(Student.class);
		student1.showdetails();
	}

}

//Student.java
package com.example6.Applicationcontext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {
	@Autowired
	private Course course;
	public void showdetails() {
		System.out.print("Student enrolled in" +course.getname());
	}
}

//Course.java
package com.example6.Applicationcontext;

import org.springframework.stereotype.Component;

@Component
public class Course {
	public String getname() {
		return "Java full stack";
	}
}
