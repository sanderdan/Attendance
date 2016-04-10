package com.attendance.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * Created by sander on 9/15/15.
 */
@Entity
@Table(name = "courses")

@NamedQueries({
        @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
        @NamedQuery(name = "Course.findById", query = "SELECT c FROM Course c WHERE c.id = :id"),

})
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    @NotNull
    private String courseName;

    @NotEmpty
    @NotNull
    private String teacher;

    @NotNull
    @Min(5)
    private int maxStudents;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
    private List<Student> students;

    public Course(String courseName, String teacher, int maxStudents) {
        this.courseName = courseName;
        this.teacher = teacher;
        this.maxStudents = maxStudents;
    }

    public Course() {
    }


    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (id != course.id) return false;
        if (maxStudents != course.maxStudents) return false;
        if (!courseName.equals(course.courseName)) return false;
        return teacher.equals(course.teacher);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + courseName.hashCode();
        result = 31 * result + teacher.hashCode();
        result = 31 * result + maxStudents;
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s [%s, %s, %s]",
                Course.class.getSimpleName(), courseName, teacher, maxStudents);
    }

}
