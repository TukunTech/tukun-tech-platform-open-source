package com.tukuntech.platform.tukun.infrastructure.persistance.jpa.patient;

import com.tukuntech.platform.tukun.domain.model.aggregates.patient.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
