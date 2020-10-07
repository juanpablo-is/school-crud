/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.sessionBean;

import com.school.entity.Course;
import com.school.entity.Period;
import com.school.entity.PeriodPK;
import com.school.entity.Student;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author Juan Pablo
 */
@Local
public interface SchoolSessionBeanLocal {

    boolean addStudent(Student student);

    boolean deleteStudent(int student);

    boolean editStudent(Student student);

    Student searchStudent(int student);

    ArrayList<String[]> getAllStudents();

    boolean addCourse(Course course);

    boolean deleteCourse(String courseID);

    boolean editCourse(Course course);

    Course searchCourse(String courseID);

    ArrayList<String[]> getAllCourses();

    boolean addPeriod(Period period);

    boolean editPeriod(Period period);

    boolean deletePeriod(PeriodPK id);

    Period searchPeriod(PeriodPK id);

    ArrayList<String[]> listPeriod(PeriodPK id, int opcion);
}
