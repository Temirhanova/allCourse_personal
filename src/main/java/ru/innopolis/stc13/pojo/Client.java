package ru.innopolis.stc13.pojo;

public class Client {
    private int id;
    private String name;
    private int id_teacher;

    public Client() {
    }

    public Client(String name, int id_teacher) {
        this.name = name;
        this.id_teacher = id_teacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId_teacher() {
        return id_teacher;
    }

    public void setId_teacher(int id_teacher) {
        this.id_teacher = id_teacher;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", id_teacher=" + id_teacher +
                '}';
    }
}
