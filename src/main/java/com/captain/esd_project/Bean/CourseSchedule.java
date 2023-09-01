package com.captain.esd_project.Bean;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "course_schedule")
public class CourseSchedule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "time", nullable = false)
    private String time;
    @Column(name = "day", nullable = false)
    private String day;
    @Column(name = "room", nullable = false)
    private String room;
    @Column(name = "building")
    private String building;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public CourseSchedule() {
    }

    public CourseSchedule(String time, String day, String room, String building, Course course) {
        this.time = time;
        this.day = day;
        this.room = room;
        this.building = building;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}
