package com.tukuntech.platform.tukun.domain.model.aggregates.elder;

import jakarta.persistence.*;

@Entity
@Table(name = "elder")
public class Elder {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
