package com.tukuntech.platform.tukun.domain.model.aggregates.criticalAlerts;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tukuntech.platform.tukun.domain.model.aggregates.elder.Elder;
import com.tukuntech.platform.tukun.domain.model.aggregates.patient.Patient;
import jakarta.persistence.*;

@Entity
@Table(name = "critical_alerts")
public class CriticalAlerts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_alert_id")
    private TypeAlert typeAlert;

    private int type;

    //Getter and Setters
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public TypeAlert getTypeAlert() {
        return typeAlert;
    }

    public void setTypeAlert(TypeAlert typeAlert) {
        this.typeAlert = typeAlert;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
