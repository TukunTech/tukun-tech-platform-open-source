package com.tukuntech.platform.tukun.domain.model.aggregates.emergencyNumbers;

import jakarta.persistence.*;

@Entity
@Table(name = "emergency_numbers")
public class EmergencyNumbers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private String contactName;

    // Getters and setters

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNumber() { return number; }

    public void setNumber(String number) { this.number = number; }

    public String getContactName() { return contactName; }

    public void setContactName(String contactName) { this.contactName = contactName; }

}
