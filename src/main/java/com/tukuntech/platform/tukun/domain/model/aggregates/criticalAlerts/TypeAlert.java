package com.tukuntech.platform.tukun.domain.model.aggregates.criticalAlerts;

import jakarta.persistence.*;

@Entity
@Table(name = "type_alert")
public class TypeAlert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
