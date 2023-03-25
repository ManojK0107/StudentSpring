package org.example.service;

import org.example.model.Student;
import org.example.repo.StudentRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements StudentServiceImpl{
     @Autowired
     StudentRepoImpl repo;
     @Override
    public void insertStudent(Student student){
         repo.insertStudent(student);
     }
    @Override
    public void insertMultiple(List<Student> studentList){
        for (int i=0;i<studentList.size();i++){
            repo.insertStudent(studentList.get(i));
        }
    }
     @Override
    public Student selectStudent(int rollNo){
        return repo.selectStudent(rollNo);
     }
     @Override
     public List<Student> selectMultiple(List<Integer> rollNos){
         List<Student> studentList=new ArrayList<>();
         for (int i=0;i<rollNos.size();i++){
             studentList.add(repo.selectStudent(rollNos.get(i)));
         }
         return studentList;
     }
     @Override
     public List<Student> selectAll(){
         return repo.selectAll();
     }
     @Override
    public Student updateStudent(Student student){
          return repo.updateStudent(student);
     }
     @Override
     public List<Student> updatetMultiple(List<Student> studentList){
         for (int i=0;i<studentList.size();i++){
             repo.updateStudent(studentList.get(i));
         }
         return studentList;
     }
     @Override
    public boolean deleteStudent(int rollNo){
         return repo.deleteStudent(rollNo);
     }
     @Override
    public List<Boolean> deleteMultiple(List<Integer> rollNos){
         List<Boolean> booleanList=new ArrayList<>();
         for (int i=0;i< rollNos.size();i++){
             booleanList.add(repo.deleteStudent(rollNos.get(i)));
         }
         return booleanList;
     }
     @Override
    public boolean deleteAll(){
         return repo.deleteAll();
     }

}
