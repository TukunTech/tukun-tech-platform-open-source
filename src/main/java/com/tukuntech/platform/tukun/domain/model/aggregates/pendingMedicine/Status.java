package com.tukuntech.platform.tukun.domain.model.aggregates.pendingMedicine;

import jakarta.persistence.*;


@Entity
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String status;



    // Getters and setters
    public int getId() {return id;}
    public void setId(int Id) {this.id = Id;}


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
