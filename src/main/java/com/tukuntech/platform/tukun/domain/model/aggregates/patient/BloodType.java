package com.tukuntech.platform.tukun.domain.model.aggregates.patient;

import jakarta.persistence.*;

@Entity
@Table(name = "blood_type")
public class BloodType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
