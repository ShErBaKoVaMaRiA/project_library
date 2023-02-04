package com.example.project_library.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Genres {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UID;

    private String name;

    public Genres() {
    }

    public Genres(String name) {
        this.name = name;
    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
