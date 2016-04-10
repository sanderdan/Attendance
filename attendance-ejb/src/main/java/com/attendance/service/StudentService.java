package com.attendance.service;

import com.attendance.domain.Student;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sander on 9/14/15.
 */
@Stateful(name="StudentServiceEJB")
public class StudentService implements StudentServiceLocal {

    @PersistenceContext
    EntityManager em;

    private List<Student> students = new ArrayList<>();
    private Query q;

    public StudentService(){
    }


    @Override
    public void addStudent(Student student) {
        em.persist(student);
        students.add(student);
    }

    @Override
    public List<Student> getStudents() {
        q = em.createQuery("select s From Student s");
        return q.getResultList();
    }

    @Override
    public Student getStudentById(int i){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        Root<Student> student = cq.from(Student.class);
        cq.where(cb.equal(student.get("id"), i));

        return em.createQuery(cq).getSingleResult();

//        q = em.createQuery("select s From Student s where s.id = :i");
//        return (Student) q.getSingleResult();
    }

    @Override
    public void deleteStudentById(int id) {
        try{
            Student student = getStudentById(id);
            em.remove(student);

        }catch (NoResultException e){

        }

    }

    @Override
    public Student editStudent(Student student) {
        return em.merge(student);
    }

}
