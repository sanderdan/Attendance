package com.attendance.beans;

import com.attendance.domain.Student;
import com.attendance.service.StudentServiceLocal;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by sander on 9/14/15.
 */
@ManagedBean
@ViewScoped
public class StudentBean {


    private Student student;
    private Student selectedStudent;
    private List<Student> selectedStudents;


    @Inject
    StudentServiceLocal studentServiceLocal;

    @PostConstruct
    public void init(){
        student = new Student();
        selectedStudent = new Student();
    }

    public void addStudent(){
        studentServiceLocal.addStudent(student);
        student = new Student();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Student> getStudents() {
        return studentServiceLocal.getStudents();
    }

    public List<Student> getSelectedStudents() {
        return selectedStudents;
    }

    public void setSelectedStudents(List<Student> selectedStudents) {
        this.selectedStudents = selectedStudents;
    }

    public Student getStudentById(int id){
        return studentServiceLocal.getStudentById(id);
    }

    public Student getSelectedStudent() {
        return selectedStudent;
    }

    public void setSelectedStudent(Student selectedStudent) {
        this.selectedStudent = selectedStudent;
    }

    public void deleteStudentById(int id){
        studentServiceLocal.deleteStudentById(id);
    }

    public void editStudent(Student student){ studentServiceLocal.editStudent(student);}



}
