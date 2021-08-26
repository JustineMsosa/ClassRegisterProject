package com.example.finaliproject;

import java.io.Serializable;
public class Student implements Serializable {
    private int id;
    private String name;
    private String Age;
    private String sex;
    String present;
    private byte[] image;
    private int studentCode;
    private String village;

    public Student(int id, String name, String age, String present, byte[] image, String sex) {
        this.id = id;
        this.name = name;
        this.Age = age;
        this.present = present;
        this.image = image;
        this.sex = sex;

    }

    public Student(int id, String name, String age, String present, byte[] image,
                   String sex, String village, int studentCode) {
        this.id = id;
        this.name = name;
        this.Age = age;
        this.present = present;
        this.image = image;
        this.sex = sex;
        this.village = village;
        this.studentCode = studentCode;

    }


    public Student(int id, String name, int studentCode) {
        this.id = id;
        this.name = name;
        this.studentCode = studentCode;
    }

    public Student(int id, String name, String age, String sex) {
        this.id = id;
        this.name = name;
        this.Age = age;
        this.sex = sex;
    }


    public int getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(int studentCode) {
        this.studentCode = studentCode;
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


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        this.Age = age;
    }

    public String getPresent() {
        return Age;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getVillage() {
        return village;
    }

    public void setPresent(String age) {
        this.Age = age;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

}
