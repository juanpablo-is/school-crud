package com.school.servlet;

import com.school.entity.Student;
import com.school.sessionBean.SchoolSessionBeanLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juan Pablo
 */
public class SchoolServlet extends HttpServlet {

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
        String first = request.getParameter("firstName");
        String last = request.getParameter("lastName");
        String idPost = request.getParameter("studentId");
        String yearPost = request.getParameter("yearLevel");
        boolean list = false;

        if (action[0].equals("List")) {
            list = true;
            String headers[] = new String[4];
            headers[0] = "ID";
            headers[1] = "First Name";
            headers[2] = "Last Name";
            headers[3] = "Year Level";

            request.setAttribute("listName", "Student's List");
            request.setAttribute("allHeader", headers);
            request.setAttribute("allData", session.getAllStudents());
        } else if (idPost.isEmpty()) {
            request.setAttribute("errorSchoolID", "errorMensaje");
            request.setAttribute("idSchool", "Debe ingresar el ID");
        } else {
            int id = Integer.parseInt(idPost);
            Student student = new Student();
            student.setStudentid(id);

            switch (action[0]) {

                case "Add":

                    if (first.isEmpty()) {
                        request.setAttribute("firstSchool", "No puede estar vacio");
                        request.setAttribute("errorFirstSchool", "errorMensaje");
                    } else {
                        student.setFirstname(first);
                    }
                    if (last.isEmpty()) {
                        request.setAttribute("lastSchool", "No puede estar vacio");
                        request.setAttribute("errorLastSchool", "errorMensaje");
                    } else {
                        student.setLastname(last);
                    }
                    if (yearPost.isEmpty()) {
                        request.setAttribute("yearSchool", "No puede estar vacio");
                        request.setAttribute("errorYearSchool", "errorMensaje");
                    } else {
                        student.setYearlevel(Integer.parseInt(yearPost));
                    }

                    if (!first.isEmpty() && !last.isEmpty() && !yearPost.isEmpty()) {
                        if (session.addStudent(student)) {
                            request.setAttribute("studentChange", "alert alertAdd");
                            request.setAttribute("studentChangeText", "Student Added");
                        } else {
                            student = null;
                        }
                    }
                    break;
                case "Edit":

                    if (first.isEmpty()) {
                        request.setAttribute("firstSchool", "No puede estar vacio");
                        request.setAttribute("errorFirstSchool", "errorMensaje");
                    } else {
                        student.setFirstname(first);
                    }
                    if (last.isEmpty()) {
                        request.setAttribute("lastSchool", "No puede estar vacio");
                        request.setAttribute("errorLastSchool", "errorMensaje");
                    } else {
                        student.setLastname(last);
                    }
                    if (yearPost.isEmpty()) {
                        request.setAttribute("yearSchool", "No puede estar vacio");
                        request.setAttribute("errorYearSchool", "errorMensaje");
                    } else {
                        student.setYearlevel(Integer.parseInt(yearPost));
                    }

                    if (!first.isEmpty() && !last.isEmpty() && !yearPost.isEmpty()) {
                        if (session.editStudent(student)) {
                            request.setAttribute("studentChange", "alert alertEdit");
                            request.setAttribute("studentChangeText", "Student Edited");
                        } else {
                            student = null;
                        }
                    }
                    break;
                case "Search":
                    student = session.searchStudent(id);
                    break;
                case "Delete":
                    if (session.deleteStudent(id)) {
                        request.setAttribute("studentChange", "alert alertDelete");
                        request.setAttribute("studentChangeText", "Student Deleted");
                        student = null;
                    }

                    break;
            }

            request.setAttribute("student", student);
        }

        request.getRequestDispatcher(list ? "list.jsp" : "index.jsp").forward(request, response);
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
