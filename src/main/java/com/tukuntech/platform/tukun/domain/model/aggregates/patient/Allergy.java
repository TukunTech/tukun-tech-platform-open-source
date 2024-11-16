package com.tukuntech.platform.tukun.domain.model.aggregates.patient;


import jakarta.persistence.*;

@Entity
@Table(name = "allergy")
public class Allergy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAllergies() {return name;}

    public void setAllergies(String allergies) {
        this.name = allergies;
    }
}
