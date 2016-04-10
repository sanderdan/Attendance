package com.attendance.service;


import com.attendance.domain.Course;
import com.attendance.domain.Student;

import java.util.List;

/**
 * Created by sander on 9/15/15.
 */
public interface CourseServiceLocal {

    void addCourse(Course course);

    List<Course> getCourses();

    Course getCourseById(int id);

    void deleteCourseById(int id);

    Course editCourse(Course course);

    List<Student> addStudentToCourse(Student student, int id);

    List<Student> removeStudentFromCourse(Student student, int courseId);

    List<Student> getStudentsFromCourse(int courseId);


}
