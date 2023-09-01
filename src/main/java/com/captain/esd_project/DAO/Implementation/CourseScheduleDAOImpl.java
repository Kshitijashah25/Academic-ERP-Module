package com.captain.esd_project.DAO.Implementation;

import com.captain.esd_project.Bean.CourseSchedule;
import com.captain.esd_project.DAO.CourseScheduleDAO;
import com.captain.esd_project.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CourseScheduleDAOImpl implements CourseScheduleDAO {
    @Override
    public boolean addCourseSchedule(CourseSchedule courseSchedule){
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(courseSchedule);
            transaction.commit();
            return true;
        }
        catch(
                HibernateException exception){
            System.err.println("Exception in adding Course Schedule" + exception.getLocalizedMessage());
            return false;
        }
    }
}
