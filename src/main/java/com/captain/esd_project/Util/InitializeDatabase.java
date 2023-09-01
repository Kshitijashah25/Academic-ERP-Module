package com.captain.esd_project.Util;

import com.captain.esd_project.Bean.Course;
import com.captain.esd_project.Bean.CourseSchedule;
import com.captain.esd_project.Bean.Student;
import com.captain.esd_project.DAO.Implementation.StudentDAOImpl;
import com.captain.esd_project.DAO.StudentDAO;

public class InitializeDatabase {
    public static void main(String[] args) {
        addingDummyData();
    }

    private static void addingDummyData() {
        // Filling student data...
        Student student1 = new Student();
        student1.setRollNo("MT2022147");
        student1.setFirstName("Kshitija");
        student1.setLastName("Shah");
        student1.setEmailId("Kshitija.Shah@iiitb.ac.in");
        student1.setPassword("password");
        student1.setCgpa(3.99f);
        student1.setTotalCredits(4);
        student1.setGraduationYear(2024);
        student1.setSpecializationName("CSE");

        // Filling student data...
        Student student2 = new Student();
        student2.setRollNo("MT2022148");
        student2.setFirstName("Kshitija");
        student2.setLastName("Shah");
        student2.setEmailId("Kshitija.Shah1@iiitb.ac.in");
        student2.setPassword("password");
        student2.setCgpa(3.99f);
        student2.setTotalCredits(4);
        student2.setGraduationYear(2024);
        student2.setSpecializationName("CSE");

        // Filling course data
        Course course1 = new Course();
        course1.setCourseCode("CS511");
        course1.setName("Algorithms");
        course1.setDescription("Advance algorithms");
        course1.setYear(1);
        course1.setTerm(1);
        course1.setCredits(4);
        course1.setCapacity(150);
        course1.setFacultyName("Murali Sir");

        Course course2 = new Course();
        course2.setCourseCode("CS512");
        course2.setName("Algorithms");
        course2.setDescription("Advance algorithms");
        course2.setYear(1);
        course2.setTerm(1);
        course2.setCredits(4);
        course2.setCapacity(150);
        course2.setFacultyName("Murali Sir");

        Course course3 = new Course();
        course3.setCourseCode("CS513");
        course3.setName("Algorithms");
        course3.setDescription("Advance algorithms");
        course3.setYear(1);
        course3.setTerm(1);
        course3.setCredits(4);
        course3.setCapacity(150);
        course3.setFacultyName("Murali Sir");

        Course course4 = new Course();
        course4.setCourseCode("CS514");
        course4.setName("Algorithms");
        course4.setDescription("Advance algorithms");
        course4.setYear(1);
        course4.setTerm(1);
        course4.setCredits(4);
        course4.setCapacity(150);
        course4.setFacultyName("Murali Sir");

        // Filling course schedule data...
        CourseSchedule courseSchedule1 = new CourseSchedule();
        courseSchedule1.setTime("09:30");
        courseSchedule1.setDay("Monday");
        courseSchedule1.setRoom("R-103");
        courseSchedule1.setBuilding("Ramanujan");
        courseSchedule1.setCourse(course1);

        CourseSchedule courseSchedule2 = new CourseSchedule();
        courseSchedule2.setTime("09:30");
        courseSchedule2.setDay("Wednesday");
        courseSchedule2.setRoom("R-103");
        courseSchedule2.setBuilding("Ramanujan");
        courseSchedule2.setCourse(course1);

        CourseSchedule courseSchedule3 = new CourseSchedule();
        courseSchedule3.setTime("09:30");
        courseSchedule3.setDay("Saturday");
        courseSchedule3.setRoom("R-103");
        courseSchedule3.setBuilding("Ramanujan");
        courseSchedule3.setCourse(course2);

        CourseSchedule courseSchedule4 = new CourseSchedule();
        courseSchedule4.setTime("11:15");
        courseSchedule4.setDay("Saturday");
        courseSchedule4.setRoom("R-103");
        courseSchedule4.setBuilding("Ramanujan");
        courseSchedule4.setCourse(course2);

        // Filling course schedule data...
        CourseSchedule courseSchedule5 = new CourseSchedule();
        courseSchedule5.setTime("09:30");
        courseSchedule5.setDay("Monday");
        courseSchedule5.setRoom("R-103");
        courseSchedule5.setBuilding("Ramanujan");
        courseSchedule5.setCourse(course3);

        CourseSchedule courseSchedule6 = new CourseSchedule();
        courseSchedule6.setTime("09:30");
        courseSchedule6.setDay("Wednesday");
        courseSchedule6.setRoom("R-103");
        courseSchedule6.setBuilding("Ramanujan");
        courseSchedule6.setCourse(course3);

        CourseSchedule courseSchedule7 = new CourseSchedule();
        courseSchedule7.setTime("09:30");
        courseSchedule7.setDay("Saturday");
        courseSchedule7.setRoom("R-103");
        courseSchedule7.setBuilding("Ramanujan");
        courseSchedule7.setCourse(course4);

        CourseSchedule courseSchedule8 = new CourseSchedule();
        courseSchedule8.setTime("11:15");
        courseSchedule8.setDay("Saturday");
        courseSchedule8.setRoom("R-103");
        courseSchedule8.setBuilding("Ramanujan");
        courseSchedule8.setCourse(course4);

        // Filling dependency Data...
        course1.getStudentList().add(student1);
        course2.getStudentList().add(student1);
        course3.getStudentList().add(student2);
        course4.getStudentList().add(student2);
        student1.getCourseList().add(course1);
        student1.getCourseList().add(course2);
        student2.getCourseList().add(course3);
        student2.getCourseList().add(course4);

        course1.getCourseScheduleList().add(courseSchedule1);
        course1.getCourseScheduleList().add(courseSchedule2);
        course2.getCourseScheduleList().add(courseSchedule3);
        course2.getCourseScheduleList().add(courseSchedule4);
        course3.getCourseScheduleList().add(courseSchedule5);
        course3.getCourseScheduleList().add(courseSchedule6);
        course4.getCourseScheduleList().add(courseSchedule7);
        course4.getCourseScheduleList().add(courseSchedule8);

        StudentDAO studentDAO = new StudentDAOImpl();

        if (studentDAO.addStudent(student1)) {
            System.out.println("Student - 1 Added Successfully.");
        } else {
            System.err.println("Error while adding Student - 1.");
        }

        if (studentDAO.addStudent(student2)) {
            System.out.println("Student - 2 Added Successfully.");
        } else {
            System.err.println("Error while adding Student - 2.");
        }
    }
}
