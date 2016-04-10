package com.attendance.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by sander on 9/30/15.
 */
@Entity
@Table(name = "attendance")
@NamedQueries({
        @NamedQuery(name = "Attendance.findAll", query = "SELECT a FROM Attendance a"),
        @NamedQuery(name = "Attendance.findById", query = "SELECT a FROM Attendance a WHERE a.id = :id"),
        @NamedQuery(name = "Attendance.findByDate", query = "SELECT a FROM Attendance a WHERE a.date =:date")

})
public class Attendance implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    @NotNull
    private Date date;

    @OneToOne(fetch = FetchType.EAGER)
    @NotNull
    private Course course;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Student> students;

    public Attendance(Date date, Course course, List<Student> students) {
        this.date = date;
        this.course = course;
        this.students = students;
    }


    public Attendance(){
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
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

        Attendance that = (Attendance) o;

        if (id != that.id) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (course != null ? !course.equals(that.course) : that.course != null) return false;
        return !(students != null ? !students.equals(that.students) : that.students != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (course != null ? course.hashCode() : 0);
        result = 31 * result + (students != null ? students.hashCode() : 0);
        return result;
    }


}
