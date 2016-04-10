package com.attendance.service;

import com.attendance.domain.Course;
import com.attendance.domain.Student;

import javax.ejb.Stateful;
import javax.persistence.*;
import java.util.List;

/**
 * Created by sander on 9/15/15.
 */
@Stateful(name = "CourseServiceEJB")
public class CourseService implements CourseServiceLocal {

    @PersistenceContext
    EntityManager em;

    public CourseService() {
    }


    @Override
    public void addCourse(Course course) {
        em.persist(course);
    }

    @Override
    public List<Course> getCourses() {
        TypedQuery<Course> query =
                em.createNamedQuery("Course.findAll", Course.class);
        List<Course> results = query.getResultList();

        return results;
    }

    @Override
    public Course getCourseById(int id) {
        Course course = em.createNamedQuery("Course.findById", Course.class)
                .setParameter("id", id)
                .getSingleResult();

        return course;
    }

    @Override
    public void deleteCourseById(int id) {
        Course course = getCourseById(id);
        em.remove(course);
    }



    @Override
    public Course editCourse(Course course) {
            return em.merge(course);
    }

    @Override
    public List<Student> addStudentToCourse(Student student, int id) {
        Course course = getCourseById(id);
        List<Student> students = course.getStudents();
        students.add(student);

        course.setStudents(students);
        em.merge(course);

        return students;
    }

    @Override
    public List<Student> removeStudentFromCourse(Student student, int courseId) {
        Course course = getCourseById(courseId);
        List<Student> students = course.getStudents();
        students.remove(student);
        em.persist(course);
        return students;
    }


    @Override
    public List<Student> getStudentsFromCourse(int courseId){
        try {
            Course course = getCourseById(courseId);
            return course.getStudents();
        } catch (NoResultException e){
            return  null;
        }
    }
}


