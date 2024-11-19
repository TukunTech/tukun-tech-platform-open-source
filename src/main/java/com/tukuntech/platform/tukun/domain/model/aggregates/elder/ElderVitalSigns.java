package com.tukuntech.platform.tukun.domain.model.aggregates.elder;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "elder_vital_signs")
public class ElderVitalSigns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "elder_id", nullable = false)
    private Elder elder;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String time;

    private int hrBpm; // Heart rate in beats per minute
    private int systolic; // Systolic blood pressure
    private int dia; // Diastolic blood pressure
    private int spo2; // Oxygen saturation
    private double temperature; // Body temperature

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Elder getElder() {
        return elder;
    }

    public void setElder(Elder elder) {
        this.elder = elder;
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

    public int getHrBpm() {
        return hrBpm;
    }

    public void setHrBpm(int hrBpm) {
        this.hrBpm = hrBpm;
    }

    public int getSystolic() {
        return systolic;
    }

    public void setSystolic(int systolic) {
        this.systolic = systolic;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getSpo2() {
        return spo2;
    }

    public void setSpo2(int spo2) {
        this.spo2 = spo2;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
