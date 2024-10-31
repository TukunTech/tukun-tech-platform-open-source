package com.tukuntech.platform.tukun.domain.model.aggregates.appointment;

import com.tukuntech.platform.tukun.domain.model.aggregates.patient.ConsultationHistory;
import com.tukuntech.platform.tukun.domain.model.aggregates.patient.Patient;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "medical_examination")
public class MedicalExamination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consultation_id")
    private ConsultationHistory consultation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_exam_id")
    private TypeExam typeExam;

    private String results;
    private Date date;

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

    public TypeExam getTypeExam() {
        return typeExam;
    }

    public void setTypeExam(TypeExam typeExam) {
        this.typeExam = typeExam;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
