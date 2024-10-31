package com.tukuntech.platform.tukun.domain.model.aggregates.appointment;

import jakarta.persistence.*;



@Entity
@Table(name = "tipe_exam")
public class TypeExam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String typeExam;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeExam() {
        return typeExam;
    }

    public void setTypeExam(String typeExam) {
        this.typeExam = typeExam;
    }
}
