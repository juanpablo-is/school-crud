package com.school.sessionBean;

import com.school.entity.Course;
import com.school.entity.Period;
import com.school.entity.PeriodPK;
import com.school.entity.Student;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Juan Pablo
 */
@Stateless
public class SchoolSessionBean implements SchoolSessionBeanLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean addStudent(Student student) {
        Student search = searchStudent(student.getStudentid());

        if (search == null) {
            em.persist(student);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteStudent(int student) {
        Student search = searchStudent(student);

        if (search != null) {
            em.remove(searchStudent(student));
            return true;
        }
        return false;
    }

    @Override
    public boolean editStudent(Student student) {
        Student search = searchStudent(student.getStudentid());

        if (search != null) {
            em.merge(student);
            return true;
        }
        return false;
    }

    @Override
    public Student searchStudent(int student) {
        return em.find(Student.class, student);
    }

    @Override
    public ArrayList<String[]> getAllStudents() {
        List<Student> students = em.createNamedQuery("Student.findAll").getResultList();
        ArrayList<String[]> studentsFinal = new ArrayList<>();

        for (int i = 0; i < students.size(); i++) {
            String[] student = new String[4];
            student[0] = String.valueOf(students.get(i).getStudentid());
            student[1] = students.get(i).getFirstname();
            student[2] = students.get(i).getLastname();
            student[3] = String.valueOf(students.get(i).getYearlevel());
            studentsFinal.add(student);
        }
        return studentsFinal;
    }

    @Override
    public boolean addCourse(Course course) {
        Course search = searchCourse(course.getCode());

        if (search == null) {
            em.persist(course);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCourse(String courseID) {
        Course search = searchCourse(courseID);

        if (search != null) {
            em.remove(searchCourse(courseID));
            return true;
        }
        return false;
    }

    @Override
    public boolean editCourse(Course course) {
        Course search = searchCourse(course.getCode());

        if (search != null) {
            em.merge(course);
            return true;
        }
        return false;
    }

    @Override
    public Course searchCourse(String courseID) {
        return em.find(Course.class, courseID);
    }

    @Override
    public ArrayList<String[]> getAllCourses() {

        List<Course> courses = em.createNamedQuery("Course.findAll").getResultList();
        ArrayList<String[]> coursesFinal = new ArrayList<>();

        for (int i = 0; i < courses.size(); i++) {
            String[] student = new String[5];
            student[0] = courses.get(i).getCode();
            student[1] = courses.get(i).getName();
            student[2] = String.valueOf(courses.get(i).getCredits());
            student[3] = String.valueOf(courses.get(i).getSemester());
            student[4] = String.valueOf(courses.get(i).getStudents());

            coursesFinal.add(student);
        }
        return coursesFinal;
    }

    @Override
    public boolean addPeriod(Period period) {
        Student searchStudent = searchStudent(period.getPeriodPK().getIdStudent());
        Course searchCourse = searchCourse(period.getPeriodPK().getIdCourse());

        if (searchStudent != null && searchCourse != null) {
            em.persist(period);
            return true;
        }
        return false;
    }

    @Override
    public boolean editPeriod(Period period) {
        Period search = searchPeriod(period.getPeriodPK());

        if (search != null) {
            em.merge(period);
            return true;
        }
        return false;
    }

    @Override
    public boolean deletePeriod(PeriodPK period) {
        em.remove(period);
        Period search = searchPeriod(period);

        if (search != null) {
            return true;
        }
        return false;
    }

    @Override
    public Period searchPeriod(PeriodPK id) {
        return em.find(Period.class, id);
    }

    @Override
    public ArrayList<String[]> listPeriod(PeriodPK period, int opcion) {
        ArrayList<String[]> periodFinal = new ArrayList<>();
        if (opcion != 0) {
            String queryText = "";
            Query query = em.createNamedQuery(opcion == 3 ? "Period.findByAll" : opcion == 2 ? "Period.findByIdStudent" : "Period.findByIdCourse");

            if (opcion == 3) {
                query.setParameter("idStudent", period.getIdStudent());
                query.setParameter("idCourse", period.getIdCourse());
            } else if (opcion == 2) {
                query.setParameter("idStudent", period.getIdStudent());
            } else {
                query.setParameter("idCourse", period.getIdCourse());
            }

            List<Period> periods = query.getResultList();

            for (int i = 0; i < periods.size(); i++) {
                Period periodFin = periods.get(i);
                Student studentSQL = searchStudent(periodFin.getPeriodPK().getIdStudent());
                Course courseSQL = searchCourse(periodFin.getPeriodPK().getIdCourse());

                String[] student = new String[5];

                student[0] = String.valueOf(studentSQL.getStudentid());
                student[1] = studentSQL.getFirstname() + " " + studentSQL.getLastname();
                student[2] = courseSQL.getCode();
                student[3] = courseSQL.getName();
                student[4] = periodFin.getDate();

                periodFinal.add(student);
            }
        }
        return periodFinal;
    }

}
