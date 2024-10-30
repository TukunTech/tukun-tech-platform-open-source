package com.tukuntech.platform.news.infrastructure.persistance.jpa.patient;

import com.tukuntech.platform.news.domain.model.aggregates.patient.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
