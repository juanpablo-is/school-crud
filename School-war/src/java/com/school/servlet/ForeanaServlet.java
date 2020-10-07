package com.school.servlet;

import com.school.entity.Period;
import com.school.entity.PeriodPK;
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
public class ForeanaServlet extends HttpServlet {

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
        String idS = request.getParameter("studentId");
        String idCourse = request.getParameter("courseId");
        String date = request.getParameter("date");
        boolean list = false;

        if (action[0].equals("List")) {
            list = true;
            if (idS.isEmpty() && idCourse.isEmpty()) {
                System.out.println("ERROR");
                request.setAttribute("errorPeriodSID", "errorMensaje");
                request.setAttribute("periodStudentID", "Debe ingresar el ID");
                request.setAttribute("errorPeriodCID", "errorMensaje");
                request.setAttribute("periodCourseID", "Debe ingresar el ID");
                list = false;
            } else {

                String headers[] = new String[5];
                headers[0] = "Student ID";
                headers[1] = "Student Name";
                headers[2] = "Course ID";
                headers[3] = "Course Name";
                headers[4] = "Date";

                int opcion = 0;

                if (idS.isEmpty() && !idCourse.isEmpty()) {
                    //Buscando por curso
                    opcion = 1;
                } else if (!idS.isEmpty() && idCourse.isEmpty()) {
                    //Buscando por estudiante
                    opcion = 2;
                } else if (!idS.isEmpty() && !idCourse.isEmpty()) {
                    //buscando por ambas
                    opcion = 3;
                }
                request.setAttribute("listName", "Period's List");
                request.setAttribute("allHeader", headers);
                request.setAttribute("allData", session.listPeriod(new PeriodPK(idCourse, idS.isEmpty() ? 0 : Integer.parseInt(idS)), opcion));
            }

        } else if (idS.isEmpty()) {
            request.setAttribute("errorPeriodSID", "errorMensaje");
            request.setAttribute("periodStudentID", "Debe ingresar el ID");
        } else if (idCourse.isEmpty()) {
            request.setAttribute("errorPeriodCID", "errorMensaje");
            request.setAttribute("periodCourseID", "Debe ingresar el ID");
        } else {
            Period period = new Period(new PeriodPK(idCourse, Integer.parseInt(idS)), date);

            switch (action[0]) {
                case "Add":

                    if (date.isEmpty()) {
                        request.setAttribute("errorDate", "errorMensaje");
                        request.setAttribute("periodDate", "No puede estar vacio");
                    } else {
                        if (session.addPeriod(period)) {
                            request.setAttribute("periodChange", "alert alertAdd");
                            request.setAttribute("periodChangeText", "Period Added");
                        } else {
                            period = null;
                        }
                    }

                    break;
                case "Edit":

                    if (date.isEmpty()) {
                        request.setAttribute("errorDate", "errorMensaje");
                        request.setAttribute("periodDate", "No puede estar vacio");
                    } else {
                        if (session.editPeriod(period)) {
                            request.setAttribute("periodChange", "alert alertEdit");
                            request.setAttribute("periodChangeText", "Period Edited");
                        } else {
                            period = null;
                        }
                    }

                    break;
                case "Search":
                    period = session.searchPeriod(new PeriodPK(idCourse, Integer.parseInt(idS)));
                    break;
                case "Delete":
                    if (session.deletePeriod(new PeriodPK(idCourse, Integer.parseInt(idS)))) {
                        request.setAttribute("periodChange", "alert alertDelete");
                        request.setAttribute("periodChangeText", "Student Deleted");
                        period = null;
                    }
                    break;
            }

            request.setAttribute("period", period);
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
