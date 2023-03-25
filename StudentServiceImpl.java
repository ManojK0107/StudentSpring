package org.example.service;

import org.example.model.Student;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface StudentServiceImpl {
    void insertStudent(Student student);
    void insertMultiple(List<Student> studentList);
    Student selectStudent(int rollNo);
    List<Student> selectMultiple(List<Integer> rollNos);
    List<Student> selectAll();
    Student updateStudent(Student student);
    List<Student> updatetMultiple(List<Student> studentList);
    boolean deleteStudent(int rollNo);
    List<Boolean> deleteMultiple(List<Integer> rollNos);
    boolean deleteAll();

}
