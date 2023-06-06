package com.spring.servecies;

import com.spring.entities.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Object saveStudent(Student student);

    Student getStudent(int id);

    void deleteStudent(int id);
}
