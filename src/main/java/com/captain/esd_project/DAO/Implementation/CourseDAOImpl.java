package com.captain.esd_project.DAO.Implementation;

import com.captain.esd_project.Bean.Course;
import com.captain.esd_project.Bean.CourseSchedule;
import com.captain.esd_project.Bean.Student;
import com.captain.esd_project.DAO.CourseDAO;
import com.captain.esd_project.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {
    @Override
    public boolean addCourse(Course course) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(course);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            System.err.println("Exception in adding Course" + exception.getLocalizedMessage());
            return false;
        }
    }
//    public Course getCourse(Course course){
//        try (Session session = HibernateSessionUtil.getSession()) {
//            int id = course.getCourseId();
//
//            Course result = session.createQuery("from Course where courseId =: id", Course.class)
//                            .setParameter("id", id)
//                            .list().get(0);
//
//            if (result == null) {
//                return null;
//            } else {
//                List<CourseSchedule> list = result.getCourseScheduleList();
//                List<CourseSchedule> updatedList = new ArrayList<>();
//                for (CourseSchedule courseSchedule : list) {
//                    CourseSchedule object = new CourseSchedule();
//                    object.setRoom(courseSchedule.getRoom());
//                    object.setBuilding(courseSchedule.getBuilding());
//                    object.setDay(courseSchedule.getDay());
//                    object.setTime(courseSchedule.getTime());
//                    object.setId(courseSchedule.getId());
//                    updatedList.add(object);
//                }
//                result.getCourseScheduleList().clear();
//                result.getCourseScheduleList().addAll(updatedList);
//                return result;
//            }
//        } catch (HibernateException hibernateException) {
//            System.err.println("Exception in getting course information : " + hibernateException.getLocalizedMessage());
//            return null;
//        }
//    }
}