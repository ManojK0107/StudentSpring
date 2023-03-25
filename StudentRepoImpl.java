package org.example.repo;

import org.example.model.Student;

import java.util.List;

public interface StudentRepoImpl {
    void insertStudent(Student student);
    Student selectStudent(int rollNo);
    List<Student> selectAll();
    Student updateStudent(Student student);
    boolean deleteStudent(int rollNo);
    boolean deleteAll();
}
