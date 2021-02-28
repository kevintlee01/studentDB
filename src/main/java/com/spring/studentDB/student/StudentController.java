package com.spring.studentDB.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
	private final StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping("/students")
	public String getStudents(Model model) {
		model.addAttribute("students", studentService.getStudents());
		studentService.printStudents();
		return "students";
	}

	@PostMapping("/students")
	public String registerNewStudent(@ModelAttribute Student student, Model model) {
		studentService.addNewStudent(student);
		model.addAttribute("students", studentService.getStudents());
		studentService.printStudents();
		return "studentlist";
	}
}
