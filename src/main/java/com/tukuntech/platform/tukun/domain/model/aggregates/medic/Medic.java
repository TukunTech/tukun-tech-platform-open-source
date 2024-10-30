package com.tukuntech.platform.tukun.domain.model.aggregates.medic;

import com.tukuntech.platform.tukun.domain.model.aggregates.patient.Nationality;
import com.tukuntech.platform.tukun.domain.model.aggregates.patient.Specialization;
import jakarta.persistence.*;

@Entity
@Table(name = "medics")
public class Medic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "specialization_id")
    private Specialization specialization;

    private String codeCmp;
    private String contact;

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
