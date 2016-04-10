package com.attendance.service;

import com.attendance.domain.Student;

import java.util.List;

/**
 * Created by sander on 9/14/15.
 */
public interface StudentServiceLocal {

    void addStudent(Student student);

    List<Student> getStudents();

    Student getStudentById(int id);

    void deleteStudentById(int id);

    Student editStudent(Student student);
}
