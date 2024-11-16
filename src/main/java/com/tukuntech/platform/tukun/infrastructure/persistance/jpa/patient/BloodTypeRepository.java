package com.tukuntech.platform.tukun.infrastructure.persistance.jpa.patient;

import com.tukuntech.platform.tukun.domain.model.aggregates.patient.BloodType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodTypeRepository extends JpaRepository<BloodType, Long> {
}
