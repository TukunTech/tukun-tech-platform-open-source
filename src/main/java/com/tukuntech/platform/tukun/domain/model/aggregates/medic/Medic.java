package com.tukuntech.platform.tukun.domain.model.aggregates.medic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tukuntech.platform.tukun.domain.model.aggregates.patient.Nationality;
import jakarta.persistence.*;

@Entity
@Table(name = "medics")
public class Medic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String dni;
    private int age;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "specialization_id")
    private Specialization specialization;

    private String codeCmp;
    private String contact;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nationality_id")
    private Nationality nationality;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public String getCodeCmp() {
        return codeCmp;
    }

    public void setCodeCmp(String codeCmp) {
        this.codeCmp = codeCmp;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }
}
