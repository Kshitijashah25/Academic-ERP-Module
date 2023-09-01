package com.captain.esd_project.Controller;

import com.captain.esd_project.Bean.Course;
import com.captain.esd_project.Bean.CourseSchedule;
import com.captain.esd_project.Bean.Student;
import com.captain.esd_project.DAO.CourseDAO;
import com.captain.esd_project.DAO.Implementation.CourseDAOImpl;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/course")
public class CourseController {
    CourseDAO courseDAO = new CourseDAOImpl();

    @POST
    @Path("/add")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCourse(Course course) {
        if (this.courseDAO.addCourse(course)) {
            return Response.status(200).entity("Success").build();
        }
        return Response.status(404).entity("Failure while adding course").build();
    }

//    @POST
//    @Path("/fetch")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response getCourse(Course course)
//    {
//        Course gettingcourse = courseDAO.getCourse(course);
//        //gettingcourse.getCourseScheduleList().forEach(course1 -> {course1.get().clear();});
//        System.out.println(gettingcourse);
//        if(gettingcourse == null){
//            return Response.status(401).build();
//        }
//        else{
//            return Response.ok().entity(gettingcourse).build();
//        }
//    }
}
