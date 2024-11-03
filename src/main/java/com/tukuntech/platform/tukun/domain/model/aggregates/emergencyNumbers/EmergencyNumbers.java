package com.tukuntech.platform.tukun.domain.model.aggregates.emergencyNumbers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "emergency_numbers")
public class EmergencyNumbers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_name_id")
    private ContactName contactName;

    // Getters and setters

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNumber() { return number; }

    public void setNumber(String number) { this.number = number; }

    public ContactName getContactName() { return contactName; }

    public void setContactName(ContactName contactName) { this.contactName = contactName; }

}
