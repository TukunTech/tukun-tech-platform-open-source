package com.tukuntech.platform.tukun.infrastructure.persistance.jpa.elder;


import com.tukuntech.platform.tukun.domain.model.aggregates.patient.MedicalInsurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalInsuranceRepository extends JpaRepository<MedicalInsurance, Long> {
}
