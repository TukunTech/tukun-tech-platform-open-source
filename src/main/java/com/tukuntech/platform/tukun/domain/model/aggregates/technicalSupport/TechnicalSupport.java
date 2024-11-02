package com.tukuntech.platform.tukun.domain.model.aggregates.technicalSupport;

import jakarta.persistence.*;

@Entity
@Table(name = "technical_support")
public class TechnicalSupport {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

private String message;

//Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

