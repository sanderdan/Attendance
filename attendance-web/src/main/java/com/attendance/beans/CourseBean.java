package com.attendance.beans;

import com.attendance.domain.Course;
import com.attendance.domain.Student;
import com.attendance.service.CourseServiceLocal;

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
public class CourseBean {

    private Course course;
    private Course selectedCourse;


    @Inject
    CourseServiceLocal courseServiceLocal;

    @PostConstruct
    public void init() {
        course = new Course();
        selectedCourse = new Course();
    }


    public void addCourse() {
        courseServiceLocal.addCourse(course);
        course = new Course();
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
        selectedCourse = course;
    }

    public List<Course> getCourses() {
        return courseServiceLocal.getCourses();
    }

    public Course getCourseById(int id) {
        return courseServiceLocal.getCourseById(id);
    }

    public Course getSelectedCourse() {
        return selectedCourse;
    }

    public void setSelectedCourse(Course selectedCourse) {
        this.selectedCourse = selectedCourse;
    }

    public void deleteCourseById(int id) {
        courseServiceLocal.deleteCourseById(id);
    }

    public void editCourse(Course course) {
        courseServiceLocal.editCourse(course);
    }

    public List<Student> addStudentToCourse(Student student, int courseId){
        return courseServiceLocal.addStudentToCourse(student, courseId);
    }

    public List<Student> getStudentsFromCourse(int courseId){
        return courseServiceLocal.getStudentsFromCourse(courseId);
    }

    public List<Student> removeStudentFromCourse(Student student, int courseId){
        return courseServiceLocal.removeStudentFromCourse(student, courseId);
    }
}
