package com.attendance.service;

import com.attendance.domain.Attendance;

import java.util.Date;
import java.util.List;

/**
 * Created by sander on 9/30/15.
 */
public interface AttendanceServiceLocal {


    void addAttendance(Attendance attendance);

    List<Attendance> getAttendances();

    Attendance getAttendanceById(int id);

    List<Attendance> getAttendancesByDate(Date date);

}
