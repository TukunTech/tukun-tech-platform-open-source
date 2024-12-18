package com.tukuntech.platform.tukun.domain.model.aggregates.elder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.data.domain.AbstractAggregateRoot;

@Entity
@Table(name = "elderBed")
public class ElderBed extends AbstractAggregateRoot<ElderBed> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int hr;
    private String nipb;
    private int sp02;
    private float temp;


    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "elder_id")
    private Elder elder;

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

    public Elder getElder() {
        return elder;
    }

    public void setElder(Elder elder) {
        this.elder = elder;
    }
}


