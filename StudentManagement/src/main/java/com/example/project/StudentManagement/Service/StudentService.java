package com.example.project.StudentManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.StudentManagement.Model.Student;
import com.example.project.StudentManagement.Repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository resp;

	public Student saveStudent(Student stud) {
		return resp.save(stud);
	}
	public List<Student> saveStudents(List<Student> studs) {
		return resp.saveAll(studs);
	}
	public List<Student> getStudents(){
		return resp.findAll();
	}
	public Student getStudentById(int id){
		return resp.findById(id).orElse(null);
	}
	public Student getStudentByName(String name){
		return resp.findByName(name);
	}
	public String deleteStudent(int id) {
		resp.deleteById(id);
		return "Student Removed || "+id;
	}
	public Student updateStudent(Student stud) {
		Student exstud=resp.findById(stud.getId()).orElse(null);
		exstud.setName(stud.getName());
		exstud.setPhoneno(stud.getPhoneno());
		exstud.setEmail(stud.getEmail());
		return resp.save(exstud);
	}
}
