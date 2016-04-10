package com.attendance.service;

import com.attendance.domain.Attendance;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

/**
 * Created by sander on 9/30/15.
 */
@Stateful(name = "AttandanceServiceEJB")
public class AttendanceService implements AttendanceServiceLocal {

    @PersistenceContext
    EntityManager em;

    public AttendanceService(){
    }

    @Override
    public void addAttendance(Attendance attendance) {
        em.persist(attendance);
    }

    @Override
    public List<Attendance> getAttendances() {
        TypedQuery<Attendance> query =
                em.createNamedQuery("Attendance.findAll", Attendance.class);
        List<Attendance> results = query.getResultList();

        return results;
    }

    @Override
    public Attendance getAttendanceById(int id) {
        try {
            Attendance attendance = em.createNamedQuery("Attendance.findById", Attendance.class)
                    .setParameter("id", id)
                    .getSingleResult();

            return attendance;
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public List<Attendance> getAttendancesByDate(Date date) {
        TypedQuery<Attendance> query =
                em.createNamedQuery("Attendance.findByDate", Attendance.class)
                .setParameter("date", date);
        List<Attendance> results = query.getResultList();
        return results;
    }






}
