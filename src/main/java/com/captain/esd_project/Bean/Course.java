package com.captain.esd_project.Bean;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Course implements Serializable {
    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;
    @Column(name = "course_code", unique = true, nullable = false)
    private String courseCode;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "year", nullable = false)
    private int year;
    @Column(name = "term", nullable = false)
    private int term;
    @Column(name = "credits", nullable = false)
    private int credits;
    @Column(name = "capacity", nullable = false)
    private int capacity;
    @Column(name = "faculty_name", nullable = false)
    private String facultyName;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "courseList", cascade = {CascadeType.ALL})
    private List<Student> studentList = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "course", cascade = {CascadeType.ALL})
    private List<CourseSchedule> CourseScheduleList = new ArrayList<>();

    public Course() {
    }

    public Course(int courseId, String courseCode, String name, String description, int year, int term, int credits, int capacity, String facultyName) {
        this.courseId = courseId;
        this.courseCode = courseCode;
        this.name = name;
        this.description = description;
        this.year = year;
        this.term = term;
        this.credits = credits;
        this.capacity = capacity;
        this.facultyName = facultyName;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<CourseSchedule> getCourseScheduleList() {
        return CourseScheduleList;
    }

    public void setCourseScheduleList(List<CourseSchedule> courseScheduleList) {
        CourseScheduleList = courseScheduleList;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseCode='" + courseCode + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", year=" + year +
                ", term=" + term +
                ", credits=" + credits +
                ", capacity=" + capacity +
                ", facultyName='" + facultyName + '\'' +
                ", courseScheduleList=" + CourseScheduleList +
                '}';
    }
}
