package com.example.hibernate_practice.entity;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity
@Component("subject_bean")
@Table(name = "subjects")
public class Subject {


    public Subject() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

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

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id + "\n" +
                ", name='" + name + '\'' + "\n" +
                '}';
    }
}
