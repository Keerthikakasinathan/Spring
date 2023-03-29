package com.example.project.StudentManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.StudentManagement.Model.Student;

public interface StudentRepository  extends JpaRepository<Student,Integer> {
	Student findByName(String name);
}
