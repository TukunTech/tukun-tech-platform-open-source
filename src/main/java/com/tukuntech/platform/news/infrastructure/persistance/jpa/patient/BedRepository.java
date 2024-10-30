package com.tukuntech.platform.news.infrastructure.persistance.jpa.patient;

import com.tukuntech.platform.news.domain.model.aggregates.patient.Bed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BedRepository extends JpaRepository<Bed, Long> {
}
