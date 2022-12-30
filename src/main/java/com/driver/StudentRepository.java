package com.driver;

import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class StudentRepository {


    //Structures to Save Information
    public HashMap<String, Student> studentList = new HashMap<>();
    public HashMap<String, Teacher>  teacherList = new HashMap<>();
    public HashMap<String, List<String>> studentTeacherMap = new HashMap<>();


    //addStudent
    public void addStudent(Student student){
        studentList.put(student.getName(), student);
    }

    //addTeacher
    public void addTeacher(Teacher teacher){
        teacherList.put(teacher.getName(), teacher);
    }

    //addStudentTeacherPair
    public void addStudentTeacher(String student, String teacher){
        if(studentList.containsKey(student) && teacherList.containsKey(teacher)){
            List<String> studentsUnderTeacher = new ArrayList<>();
            if(studentTeacherMap.containsKey(teacher)){
                studentsUnderTeacher = studentTeacherMap.get(teacher);
            }
            studentsUnderTeacher.add(student);
            studentTeacherMap.put(teacher, studentsUnderTeacher);
        }
    }

    //grtStudent
    public Student getStudentByName(String name){
        if(!studentList.containsKey(name)){
            return null;
        }
        return studentList.get(name);
    }

    //getTeacherByName
    public Teacher getTeacherByName(String name){
        if(!teacherList.containsKey(name)){
            return null;
        }
        return teacherList.get(name);
    }

    //getStudentByTeacher
    public List<String> getStudentByTeacherName(String name){
        List<String> studentList = new ArrayList<>();
        if(studentTeacherMap.containsKey(name)){
            studentList = studentTeacherMap.get(name);
        }
        return studentList;
    }

    //AllStudents
    public List<String> getAllStudents(){
        ArrayList<String >AllStudent = new ArrayList(studentList.keySet());
        return AllStudent;
    }

    //deleteTeacherByName
    public void deleteTeacherByName(String name){
        List<String> students = new ArrayList<>();
        if(studentTeacherMap.containsKey(name)){
            students = studentTeacherMap.get(name);

            for(String std:students){
                if(studentList.containsKey(std)){
                    studentList.remove(std);
                }
            }
            studentTeacherMap.remove(name);
        }
        if(teacherList.containsKey(name)){
            teacherList.remove(name);
        }
    }

    //DeleteEverything!
    public void deleteAllTeachers(){
        teacherList = new HashMap<>();
        HashSet<String> TempStudent = new HashSet<>();

        for(String teacher : studentTeacherMap.keySet()){
            for(String student : studentTeacherMap.get(teacher)){
                TempStudent.add(student);
            }
        }
        for(String student : TempStudent){
            if(studentList.containsKey(student)){
                studentList.remove(student);
            }
            studentTeacherMap = new HashMap<>();
        }
    }
}