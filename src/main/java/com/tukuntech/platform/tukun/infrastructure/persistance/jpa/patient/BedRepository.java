package com.tukuntech.platform.tukun.infrastructure.persistance.jpa.patient;

import com.tukuntech.platform.tukun.domain.model.aggregates.patient.Bed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BedRepository extends JpaRepository<Bed, Long> {
}
