package com.tukuntech.platform.tukun.domain.model.aggregates.patient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.data.domain.AbstractAggregateRoot;

@Entity
@Table(name = "bed")
public class Bed extends AbstractAggregateRoot<Bed> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int hr;
    private String nipb;
    private int sp02;
    private float temp;


    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getHr() {
        return hr;
    }

    public void setHr(int hr) {
        this.hr = hr;
    }

    public String getNipb() {
        return nipb;
    }

    public void setNipb(String nipb) {
        this.nipb = nipb;
    }

    public int getSp02() {
        return sp02;
    }

    public void setSp02(int sp02) {
        this.sp02 = sp02;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}


