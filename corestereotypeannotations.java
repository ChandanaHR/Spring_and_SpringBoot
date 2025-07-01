//students.html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Students List</title>
</head>
<body>
    <h2>List of Students</h2>
    <ul>
        <li th:each="student:${students}">
            <span th:text="${student.id}"></span>
            <span th:text="${student.name}"></span>
        </li>
    </ul>
</body>
</html>

//Student.java
  package com.example7.Annotations;

public class Student {
	private int id;
	private String name;
	public Student(int id,String name) {
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

//StudentController.java
package com.example7.Annotations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentservice;
	@GetMapping("/students")
	public String viewStudents(Model model) {
		List<Student> students = studentservice.getStudents();
		model.addAttribute("students",students);
		return "students";
	}
}
//StudentService.java
package com.example7.Annotations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentrepository;
	public List<Student> getStudents() {
		return studentrepository.getAllStudents();
	}
}
//StudentRepository.java
package com.example7.Annotations;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
	public List<Student> getAllStudents() {
		return Arrays.asList(
				new Student(1, "chandu"),
				new Student(2, "krishna")
			);
	}
}

