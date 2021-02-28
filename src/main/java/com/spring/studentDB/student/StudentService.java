package com.spring.studentDB.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if(studentOptional.isPresent()) {
            throw new IllegalStateException("Email Taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        Boolean exists = studentRepository.existsById(studentId);

        if(!exists) {
            throw new IllegalStateException("Student ID " + studentId + " does not exist!");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String firstname, String lastname, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new IllegalStateException(
                        "Student ID" + studentId + "does not exist!"
                )
        );

        if(firstname != null && firstname.length() > 0 && lastname != null && lastname.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            student.setFirstname(firstname);
            student.setLastname(lastname);
        }

        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);

            if(studentOptional.isPresent()) {
                throw new IllegalStateException(email + " is taken!");
            }
            student.setEmail(email);
        }
    }

    public void printStudents() {
        System.out.print(studentRepository.findAll());
    }
}
