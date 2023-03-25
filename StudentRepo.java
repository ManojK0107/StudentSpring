package org.example.repo;

import org.example.model.Student;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo implements StudentRepoImpl{
    @Override
    public void insertStudent(Student student){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/info", "root", "");
            Statement stmt= con.createStatement();
            stmt.executeUpdate("insert into student values('"+student.getRollNo()+"','"+student.getName()+"','"+student.getEmail()+"')");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    @Override
    public Student selectStudent(int rollNo){
        Student student=new Student();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/info", "root", "");
            Statement stmt= con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from student where rollNo='"+rollNo+"'");
            while (rs.next()){
                student.setRollNo(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setEmail(rs.getString(3));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return student;
    }
    @Override
    public List<Student> selectAll(){
        List<Student> studentList=new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/info", "root", "");
            Statement stmt= con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from student");
            while (rs.next()){
                Student student=new Student();
                student.setRollNo(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setEmail(rs.getString(3));
                studentList.add(student);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return studentList;
    }
    @Override
    public Student updateStudent(Student student){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/info", "root", "");
            Statement stmt= con.createStatement();
            stmt.executeUpdate("update student set name='"+student.getName()+"',email='"+student.getEmail()+"'where rollNo='"+student.getRollNo()+"'");
        }
        catch (Exception e){
            System.out.println(e);
        }
        return selectStudent(student.getRollNo());
    }
    @Override
    public boolean deleteStudent(int rollNo){
        boolean result=false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/info", "root", "");
            Statement stmt= con.createStatement();
            int count=stmt.executeUpdate("delete from student where rollNo='"+rollNo+"'");
            if (count>0){
                result=true;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return result;
    }
    @Override
    public boolean deleteAll(){
        boolean result=false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/info", "root", "");
            Statement stmt= con.createStatement();
            int count=stmt.executeUpdate("delete from student");
            if (count>0){
                result=true;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return result;
    }
}
