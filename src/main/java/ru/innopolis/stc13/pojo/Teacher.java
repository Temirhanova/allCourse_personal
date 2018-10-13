package ru.innopolis.stc13.pojo;

public class Teacher {
    private int id;
    private int id_user; //User
    private boolean active;
    private float price;
    private String cvalification;

    public Teacher(int id_user, boolean active, float price, String cvalification) {
        this.id_user = id_user;
        this.active = active;
        this.price = price;
        this.cvalification = cvalification;
    }

    public Teacher() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCvalification() {
        return cvalification;
    }

    public void setCvalification(String cvalification) {
        this.cvalification = cvalification;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", id_user=" + id_user +
                ", active=" + active +
                ", price=" + price +
                ", cvalification='" + cvalification + '\'' +
                '}';
    }
}
