package ru.innopolis.stc13.pojo;


import java.sql.Date;

public class Lesson {
    private int id;
    private Date date;
    private int id_course;

    public Lesson() {
    }

    public Lesson(Date date, int id_course) {
        this.date = date;
        this.id_course = id_course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId_course() {
        return id_course;
    }

    public void setId_course(int id_course) {
        this.id_course = id_course;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", date=" + date +
                ", id_course=" + id_course +
                '}';
    }
}
