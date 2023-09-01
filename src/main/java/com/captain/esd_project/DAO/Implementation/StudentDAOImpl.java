package com.captain.esd_project.DAO.Implementation;

import com.captain.esd_project.Bean.Course;
import com.captain.esd_project.Bean.CourseSchedule;
import com.captain.esd_project.Bean.Student;
import com.captain.esd_project.DAO.StudentDAO;
import com.captain.esd_project.Util.HibernateSessionUtil;
import jakarta.json.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean addStudent(Student student) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            System.err.println("Exception in adding Student" + exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public Student loginStudent(Student student) {
        try (Session session = HibernateSessionUtil.getSession()) {
            String studentEmail = student.getEmailId();
            String studentPassword = student.getPassword();

            List<Object> result = new ArrayList<>(
                    session.createQuery("from Student where emailId =: email and password =: password")
                            .setParameter("email", studentEmail)
                            .setParameter("password", studentPassword)
                            .list()
            );
            if (result.size() == 0) {
                return null;
            } else {
                Student student1 = (Student) result.get(0);
                student1.getCourseList().clear();
                return student1;
            }
        } catch (HibernateException hibernateException) {
            System.err.println("Exception in Logging in Student : " + hibernateException.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public List<CourseSchedule> getCourseSchedules(Student student) {
        try (Session session = HibernateSessionUtil.getSession()) {
            String studentEmail = student.getEmailId();
            String studentPassword = student.getPassword();

            List<Student> result = new ArrayList<>(
                    session.createQuery("from Student where emailId =: email and password =: password", Student.class)
                            .setParameter("email", studentEmail)
                            .setParameter("password", studentPassword)
                            .list()
            );

            if (result.size() == 0) {
                return null;
            }
            List<Course> courseList = result.get(0).getCourseList();
            List<CourseSchedule> courseScheduleList = new ArrayList<>();

            for (Course course : courseList) {
                Course object = session.createQuery("from Course where courseId =: id", Course.class)
                        .setParameter("id", course.getCourseId())
                        .list().get(0);
                if (object == null) {
                    return null;
                }
                List<CourseSchedule> list = object.getCourseScheduleList();
                for (CourseSchedule courseSchedule : list) {
                    CourseSchedule obj = new CourseSchedule();
                    obj.setRoom(courseSchedule.getRoom());
                    obj.setBuilding(courseSchedule.getBuilding());
                    obj.setDay(courseSchedule.getDay());
                    obj.setTime(courseSchedule.getTime());
                    obj.setId(courseSchedule.getId());
                    System.out.println("I am here...");
                    courseScheduleList.add(obj);
                }
            }
            return courseScheduleList;
        } catch (HibernateException hibernateException) {
            System.err.println("Exception in getting course schedule: " + hibernateException.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public List<Course> courseAndTimeTable(int studentId) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            Student student = session.load(Student.class, studentId);
            List<Course> courseList = student.getCourseList();

            for (Course course : courseList) {
                course.getStudentList().clear();

                course.getCourseScheduleList().forEach(courseSchedule -> {
                    courseSchedule.setCourse(new Course(course.getCourseId(), course.getCourseCode(), course.getName(), course.getDescription(), course.getYear(), course.getTerm(), course.getCredits(), course.getCapacity(), course.getFacultyName()));
                });
            }
            transaction.commit();
            return courseList;
        }   catch (HibernateException hibernateException) {
            System.err.println("Exception in fetching course list.");
            return null;
        }
    }

/*
    @Override
    public Student getStudentByID(int id) {
        System.out.println(id);
        try(Session session = HibernateSessionUtil.getSession()){
            Query query = session.createQuery("from Student where studentId=:S_id");
            query.setParameter("S_id", id);
            return (Student) query.list().get(0);
        }
    }

    /* @Override
     public Student getStudentByID(int studentID) {
         try (Session session = HibernateSessionUtil.getSession()) {
             return session.get(Student.class, studentID);
         } catch (HibernateException exception) {
             System.out.print(exception.getLocalizedMessage());
         }
         return null;*/
}
