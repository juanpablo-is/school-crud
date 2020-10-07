<%-- 
    Document   : index
    Created on : 20/03/2020, 06:15:30 PM
    Author     : Juan Pablo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>School Information</title>
        <link href="https://fonts.googleapis.com/css?family=Barlow:300,400,700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/styles.css"/>
    </head>
    <body>
        <main>
            <section class="informacionIndependiente">
                <section class="sectionStudent">
                    <div class="information">
                        <h2>Student Information</h2>
                        <div class="${studentChange}"><h2>${studentChangeText}</h2></div>
                        <form action="./SchoolServlet" method="POST" id="form">
                            <div>
                                <label for="studentId">Student ID</label>
                                <input id="studentId" type="number" class="${errorSchoolID}" placeholder="${idSchool}" min="1" name="studentId" value="${student.studentid}" />
                            </div>

                            <div>

                                <label for="firstName">First Name</label>
                                <input id="firstName" type="text" class="${errorFirstSchool}" placeholder="${firstSchool}" name="firstName" value="${student.firstname}" />
                            </div>
                            <div>

                                <label for="lastName">Last Name</label>
                                <input id="lastName" type="text" class="${errorLastSchool}" placeholder="${lastSchool}" name="lastName" value="${student.lastname}" />
                            </div>
                            <div>

                                <label for="yearLevel">Year Level</label>
                                <input id="yearLevel" type="number" class="${errorYearSchool}" placeholder="${yearSchool}" name="yearLevel" value="${student.yearlevel}" />
                            </div>
                            <div id="btns">
                                <input id="addButton" type="submit" name="action" value="Add" />
                                <input id="editButton" type="submit" name="action" value="Edit" />
                                <input id="deleteButton" type="submit" name="action" value="Delete" />
                                <input id="searchButton" type="submit" name="action" value="Search" />
                                <input id="listButton" type="submit" name="action" value="List Student" />
                            </div>
                        </form>
                    </div>
                </section>
                <section class="sectionCourse">
                    <div class="information">
                        <h2>Course Information</h2>
                        <div class="${courseChange}"><h2>${courseChangeText}</h2></div>
                        <form action="./CourseServlet" method="POST" id="form">
                            <div>
                                <label for="courseID">Course ID</label>
                                <input id="courseID" type="text" class="${errorCourseID}" placeholder="${idCourse}" name="courseID" value="${course.code}" />
                            </div>

                            <div>
                                <label for="courseName">Name</label>
                                <input id="courseName" type="text" class="${errorNameCourse}" placeholder="${nameCourse}" name="courseName" value="${course.name}" />
                            </div>

                            <div>
                                <label for="courseCredits">Credit Numbers</label>
                                <input id="courseCredits" type="number" class="${errorCreditsCourse}" placeholder="${creditsCourse}" name="courseCredits" value="${course.credits}" />
                            </div>

                            <div>
                                <label for="courseSemesters">Semesters</label>
                                <input id="courseSemesters" type="number" class="${errorSemestersCourse}" placeholder="${semestersCourse}" name="courseSemesters" value="${course.semester}" />
                            </div>

                            <div>
                                <label for="courseStudents">Number of Students</label>
                                <input id="courseStudents" type="number" class="${errorStudentsCourse}" placeholder="${studentsCourse}" name="courseStudents" value="${course.students}" />
                            </div>

                            <div id="btns">
                                <input id="addButton" type="submit" name="action" value="Add" />
                                <input id="editButton" type="submit" name="action" value="Edit" />
                                <input id="deleteButton" type="submit" name="action" value="Delete" />
                                <input id="searchButton" type="submit" name="action" value="Search" />
                                <input id="listButton" type="submit" name="action" value="List Course" />
                            </div>
                        </form>
                    </div>
                </section>
            </section>
            <section class="informacionForeana">
                <div class="information">
                    <h2>Period Information</h2>
                    <div class="${periodChange}"><h2>${periodChangeText}</h2></div>

                    <form action="./ForeanaServlet" method="POST" id="formForeana">
                        <div>
                            <label for="periodStudentID">Student ID</label>
                            <input id="periodStudentID" type="text" class="${errorPeriodSID}" placeholder="${periodStudentID}" name="studentId" value="${period.periodPK.idStudent}" />
                        </div>

                        <div>
                            <label for="periodCourseID">Course ID</label>
                            <input id="periodCourseID" type="text" class="${errorPeriodCID}" placeholder="${periodCourseID}" name="courseId" value="${period.periodPK.idCourse}" />
                        </div>

                        <div>
                            <label for="date">Date</label>
                            <input id="date" type="date" class="${errorDate}" placeholder="${periodDate}" name="date" value="${period.date}" />
                        </div>

                        <div id="btns">
                            <input id="addButton" type="submit" name="action" value="Add" />
                            <input id="editButton" type="submit" name="action" value="Edit" />
                            <input id="deleteButton" type="submit" name="action" value="Delete" />
                            <input id="searchButton" type="submit" name="action" value="Search" />
                            <input id="listButton" type="submit" name="action" value="List Period" />
                        </div>
                    </form>
                </div>
            </section>
        </main>
    </body>
</html>