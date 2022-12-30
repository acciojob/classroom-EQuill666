package com.driver;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentService {
    @Autowired
    StudentRepository stdRepository;

    //addStd
    public void addStudent(Student std){
        stdRepository.addStudent(std);
    }

    //addTeach
    public void addTeacher(Teacher tech){
        stdRepository.addTeacher(tech);
    }

    //getStdByName
    public Student getStudentByName(String name){
        return stdRepository.getStudentByName(name);
    }

    //getTechByName
    public Teacher getTeacherByName(String name){
        return stdRepository.getTeacherByName(name);
    }

    //addStd-TechPair
    public void addStudentTeacher(String std, String tech){
        stdRepository.addStudentTeacher(std, tech);
    }

    //getStudentByTeacher
    public List<String> getStudentByTeacherName(String name){
        return stdRepository.getStudentByTeacherName(name);
    }

    //getAllStd
    public List<String> getAllStudents(){
        return stdRepository.getAllStudents();
    }

    //deleteTechByName
    public void deleteTeacherByName(String name){
        stdRepository.deleteTeacherByName(name);
    }

    //DeleteAllTech
    public void deleteAllTeachers(){
        stdRepository.deleteAllTeachers();
    }
}
