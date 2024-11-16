package com.tukuntech.platform.tukun.domain.model.aggregates.patient;

import jakarta.persistence.*;


@Entity
@Table(name = "medical_insurance")
public class MedicalInsurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medical;
    //private String policyNumber;

    // Getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedical() {
        return medical;
    }

    public void setMedical(String medical) {
        this.medical = medical;
    }

   // public String getPolicyNumber() {return policyNumber;}

   // public void setPolicyNumber(String policyNumber) {this.policyNumber = policyNumber;}
}

