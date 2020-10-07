/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.servlet;

import com.school.entity.Course;
import com.school.entity.Student;
import com.school.sessionBean.SchoolSessionBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juan Pablo
 */
public class CourseServlet extends HttpServlet {

    @EJB
    private SchoolSessionBeanLocal session;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action[] = request.getParameter("action").split(" ");
        String id = request.getParameter("courseID");
        String name = request.getParameter("courseName");
        String credits = request.getParameter("courseCredits");
        String semesters = request.getParameter("courseSemesters");
        String students = request.getParameter("courseStudents");

        boolean list = false;

        if (action[0].equals("List")) {
            list = true;
            String headers[] = new String[5];
            headers[0] = "ID";
            headers[1] = "Name";
            headers[2] = "Credits Number";
            headers[3] = "Semesters";
            headers[4] = "Students Number";

            request.setAttribute("listName", "Course's List");
            request.setAttribute("allHeader", headers);
            request.setAttribute("allData", session.getAllCourses());
        } else if (id.isEmpty()) {
            request.setAttribute("errorCourseID", "errorMensaje");
            request.setAttribute("idCourse", "Debe ingresar el ID");
        } else {
            Course course = new Course();
            course.setCode(id);

            switch (action[0]) {
                case "Add":

                    if (name.isEmpty()) {
                        request.setAttribute("nameCourse", "No puede estar vacio");
                        request.setAttribute("errorNameCourse", "errorMensaje");
                    } else {
                        course.setName(name);
                    }
                    if (credits.isEmpty()) {
                        request.setAttribute("creditsCourse", "No puede estar vacio");
                        request.setAttribute("errorCreditsCourse", "errorMensaje");
                    } else {
                        course.setCredits(Integer.parseInt(credits));
                    }
                    if (semesters.isEmpty()) {
                        request.setAttribute("semestersCourse", "No puede estar vacio");
                        request.setAttribute("errorSemestersCourse", "errorMensaje");
                    } else {
                        course.setSemester(Integer.parseInt(semesters));
                    }
                    if (students.isEmpty()) {
                        request.setAttribute("studentsCourse", "No puede estar vacio");
                        request.setAttribute("errorStudentsCourse", "errorMensaje");
                    } else {
                        course.setStudents(Integer.parseInt(students));
                    }

                    if (!name.isEmpty() && !credits.isEmpty() && !semesters.isEmpty() && !students.isEmpty()) {
                        if (session.addCourse(course)) {
                            request.setAttribute("courseChange", "alert alertAdd");
                            request.setAttribute("courseChangeText", "Course Added");
                        } else {
                            course = null;
                        }
                    }
                    break;
                case "Edit":

                    if (name.isEmpty()) {
                        request.setAttribute("nameCourse", "No puede estar vacio");
                        request.setAttribute("errorNameCourse", "errorMensaje");
                    } else {
                        course.setName(name);
                    }
                    if (credits.isEmpty()) {
                        request.setAttribute("creditsCourse", "No puede estar vacio");
                        request.setAttribute("errorCreditsCourse", "errorMensaje");
                    } else {
                        course.setCredits(Integer.parseInt(credits));
                    }
                    if (semesters.isEmpty()) {
                        request.setAttribute("semestersCourse", "No puede estar vacio");
                        request.setAttribute("errorSemestersCourse", "errorMensaje");
                    } else {
                        course.setSemester(Integer.parseInt(semesters));
                    }
                    if (students.isEmpty()) {
                        request.setAttribute("studentsCourse", "No puede estar vacio");
                        request.setAttribute("errorStudentsCourse", "errorMensaje");
                    } else {
                        course.setStudents(Integer.parseInt(students));
                    }

                    if (!name.isEmpty() && !credits.isEmpty() && !semesters.isEmpty() && !students.isEmpty()) {
                        if (session.editCourse(course)) {
                            request.setAttribute("courseChange", "alert alertEdit");
                            request.setAttribute("courseChangeText", "Course Edited");
                        } else {
                            course = null;
                        }
                    }
                    break;
                case "Search":
                    course = session.searchCourse(id);
                    break;
                case "Delete":
                    if (session.deleteCourse(id)) {
                        request.setAttribute("courseChange", "alert alertDelete");
                        request.setAttribute("courseChangeText", "Course Deleted");
                        course = null;
                    }
                    break;
            }

            request.setAttribute("course", course);
        }

        request.getRequestDispatcher(list?"list.jsp":"index.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
