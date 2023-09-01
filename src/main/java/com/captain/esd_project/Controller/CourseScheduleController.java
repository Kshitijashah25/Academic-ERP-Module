package com.captain.esd_project.Controller;

import com.captain.esd_project.Bean.CourseSchedule;
import com.captain.esd_project.DAO.CourseScheduleDAO;
import com.captain.esd_project.DAO.Implementation.CourseScheduleDAOImpl;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/courseSchedule")
public class CourseScheduleController {
    CourseScheduleDAO courseScheduleDAO = new CourseScheduleDAOImpl();

    @POST
    @Path("/add")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCourseSchedule(CourseSchedule courseSchedule) {
        if (this.courseScheduleDAO.addCourseSchedule(courseSchedule)) {
            return Response.status(200).entity("Success").build();
        }
        return Response.status(404).entity("Failure while adding Course Schedule").build();
    }
}
