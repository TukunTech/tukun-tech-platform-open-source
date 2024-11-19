package com.tukuntech.platform.tukun.infrastructure.persistance.jpa.elder;

import com.tukuntech.platform.tukun.domain.model.aggregates.patient.Allergy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllergyRepository extends JpaRepository<Allergy, Long> {
}
