package com.tukuntech.platform.tukun.domain.model.aggregates.emergencyNumbers;

import jakarta.persistence.*;

@Entity
@Table(name = "contact_name")
public class ContactName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contactName;

    // Getters and setters

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return contactName; }

    public void setName(String name) { this.contactName = name; }

}
