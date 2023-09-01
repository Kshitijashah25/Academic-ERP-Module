package com.captain.esd_project.Controller;

import com.captain.esd_project.Bean.Course;
import com.captain.esd_project.Bean.CourseSchedule;
import com.captain.esd_project.Bean.Student;
import com.captain.esd_project.DAO.Implementation.StudentDAOImpl;
import com.captain.esd_project.DAO.StudentDAO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/student")
public class StudentController {
    StudentDAO studentDAO = new StudentDAOImpl();

    @POST
    @Path("/add")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addStudent(Student student) {
        if (this.studentDAO.addStudent(student)) {
            return Response.status(200).entity("Success").build();
        }
        return Response.status(404).entity("Failure while adding student").build();
    }

    /**
     * This method returns student with course list that the student is enrolled in
     * @param student
     * @return
     */
//    @POST
//    @Path("/login")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response loginStudent(Student student)
//    {
//        Student loggedInStudent = studentDAO.loginStudent(student);
//        loggedInStudent.getCourseList().forEach(course1 -> {course1.getStudentList().clear();});
//        loggedInStudent.getCourseList().forEach(course1 -> {course1.getCourseScheduleList().clear();});
//        System.out.println(loggedInStudent);
//        if(loggedInStudent == null){
//            return Response.status(401).build();
//        }
//        else{
//            return Response.ok().entity(loggedInStudent).build();
//        }
//    }

    /**
     * This method returns student details with courses
     * @param student
     * @return
     */
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response loginStudent(Student student)
    {
        Student loggedInStudent = studentDAO.loginStudent(student);
      //  loggedInStudent.getCourseList().clear();
        System.out.println(loggedInStudent);
        if(loggedInStudent == null){
            return Response.status(401).build();
        }
        else{
            return Response.ok().entity(loggedInStudent).build();
        }
    }

    @POST
    @Path("/timetable")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response timeTable(Student student)
    {
        List<CourseSchedule> courseScheduleList = studentDAO.getCourseSchedules(student);
        if(courseScheduleList == null){
            return Response.status(401).build();
        }
        else{
            return Response.ok().entity(courseScheduleList).build();
        }
    }
   /* @GET
    @Path("/get/{s_id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public Response get_employee(@PathParam("s_id") int id){
        System.out.println(id);

        Student student = this.studentDAO.getStudentByID(id);
        student.setCourseList(student.getCourseList());
        System.out.println(student);

        return Response.status(200).entity(student).build();
    }
   @GET
   @Path("/get")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getStudentById(@QueryParam("id") int id) {
       Student studentData = studentDAO.getStudentByID(id);
       if (studentData == null) {
           return Response.status(400).entity("Failure while fetching student data").build();
       }
       return Response.status(200).entity(studentData).build();
   }*/

//    @POST
//    @Path("/fetchCourseAndTimeTable")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response fetchingCourseTimeTable (@QueryParam("student_id") int studentId) {
//        List<Course> courseList = studentDAO.courseAndTimeTable(studentId);
//        if (courseList == null) {
//            return Response.status(404).entity("Error in fetching course list.").build();
//        } else {
//            return Response.ok().entity(courseList).build();
//        }
//    }

    @POST
    @Path("/fetchCourseAndTimeTable")
    @Produces(MediaType.APPLICATION_JSON)
    public Response fetchingCourseTimeTable (@QueryParam("student_id") int studentId) {
        List<Course> courseList = studentDAO.courseAndTimeTable(studentId);
        if (courseList == null) {
            return Response.status(404).entity("Error in fetching course list.").build();
        } else {
            return Response.ok().entity(courseList).build();
        }
    }
}

