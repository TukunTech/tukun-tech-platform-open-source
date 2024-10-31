package com.tukuntech.platform.tukun.domain.model.aggregates.appointment;

import jakarta.persistence.*;

@Entity
@Table(name = "type_appointment")
public class TypeAppointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String appointment;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getAppointment() {
        return appointment;
    }
    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }
}
