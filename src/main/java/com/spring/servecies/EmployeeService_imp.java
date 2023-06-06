package com.spring.servecies;

import com.spring.dao.StudentRepository;
import com.spring.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentService_imp implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        if (student.getId() == 0) {
            System.out.println("saveStudent: " + student);
            return studentRepository.save(student);
        } else {
            Student student1 = studentRepository.findById(student.getId()).orElse(null);
            if (Objects.nonNull(student1)) {
                student1.setName(student.getName());
                student1.setSurname(student.getSurname());
                student1.setEmail(student.getEmail());
                System.out.println("saveStudent: " + student1);
                return studentRepository.save(student1);
            }
            return null;
        }
    }

    @Override
    public Student getStudent(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}
