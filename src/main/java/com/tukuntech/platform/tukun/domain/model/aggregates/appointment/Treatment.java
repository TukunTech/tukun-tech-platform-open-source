package com.tukuntech.platform.tukun.domain.model.aggregates.appointment;

import com.tukuntech.platform.tukun.domain.model.aggregates.patient.ConsultationHistory;
import com.tukuntech.platform.tukun.domain.model.aggregates.patient.Patient;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "treatment")
public class Treatment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consultation_id")
    private ConsultationHistory consultation;

    private String description;
    private Date startDate;
    private Date endDate;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public ConsultationHistory getConsultation() {
        return consultation;
    }

    public void setConsultation(ConsultationHistory consultation) {
        this.consultation = consultation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}


