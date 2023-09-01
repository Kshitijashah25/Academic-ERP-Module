package com.captain.esd_project.DAO;

import com.captain.esd_project.Bean.Course;
import com.captain.esd_project.Bean.CourseSchedule;
import com.captain.esd_project.Bean.Student;
import jakarta.json.JsonArray;

import java.util.List;

public interface StudentDAO {
    boolean addStudent(Student student);

    Student loginStudent(Student student);

    List<CourseSchedule> getCourseSchedules(Student student);

    List<Course> courseAndTimeTable(int studentId);


    //Student getStudentByID(int id);

    /* @Override
         public Student getStudentByID(int studentID) {
             try (Session session = HibernateSessionUtil.getSession()) {
                 return session.get(Student.class, studentID);
             } catch (HibernateException exception) {
                 System.out.print(exception.getLocalizedMessage());
             }
             return null;*/

}
