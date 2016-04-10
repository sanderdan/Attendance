package com.attendance.beans;

import com.attendance.domain.Attendance;
import com.attendance.service.AttendanceServiceLocal;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;

/**
 * Created by sander on 9/30/15.
 */
@ManagedBean
@ViewScoped
public class AttendanceBean {

    private Attendance attendance;
    private Date selectedDate;

    @Inject
    AttendanceServiceLocal attendanceServiceLocal;

    @PostConstruct
    public void init(){
        attendance = new Attendance();
    }

    public void addAttendance(){
        attendanceServiceLocal.addAttendance(attendance);
        attendance = new Attendance();
    }

    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }


    public Date getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(Date selectedDate) {
        this.selectedDate = selectedDate;
    }

    public List<Attendance> getAttendancesByDate(Date date){
        return attendanceServiceLocal.getAttendancesByDate(date);
    }
}
