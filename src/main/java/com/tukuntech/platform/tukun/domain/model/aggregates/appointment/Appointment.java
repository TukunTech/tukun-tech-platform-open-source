package com.tukuntech.platform.tukun.domain.model.aggregates.appointment;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tukuntech.platform.tukun.domain.model.aggregates.medic.Medic;
import com.tukuntech.platform.tukun.domain.model.aggregates.patient.Patient;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medic_id")
    private Medic medic;

    private Date date;
    private String time;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_appointment")
    private TypeAppointment typeAppointment;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_method")
    private PaymentMethod paymentMethod;


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

    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public TypeAppointment getTypeAppointment() {
        return typeAppointment;
    }

    public void setTypeAppointment(TypeAppointment typeAppointment) {
        this.typeAppointment = typeAppointment;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {

        this.paymentMethod = paymentMethod;
    }
}

