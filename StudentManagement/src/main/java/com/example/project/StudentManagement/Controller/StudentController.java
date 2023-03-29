package com.example.project.StudentManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.StudentManagement.Model.Student;
import com.example.project.StudentManagement.Service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService serv;
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student stud) {
		return serv.saveStudent(stud);
	}
	@PostMapping("/addStudents")
	public List<Student> addStudents(@RequestBody List<Student> studs) {
		return serv.saveStudents(studs);
	}
	@GetMapping("/students")
	public List<Student> findAllStudents(){
		return serv.getStudents();
	}
	@GetMapping("/studentById/{id}")
	public Student findStudentById(@PathVariable int id){
		return serv.getStudentById(id);
	}
	@GetMapping("/student/{name}")
	public Student findStudentByName(@PathVariable String name){
		return serv.getStudentByName(name);
	}
	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student stud) {
		return serv.updateStudent(stud);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteStud(@PathVariable int id) {
		return serv.deleteStudent(id);
	}
}
