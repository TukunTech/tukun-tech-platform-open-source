package com.tukuntech.platform.tukun.infrastructure.persistance.jpa.elder;

import com.tukuntech.platform.tukun.domain.model.aggregates.elder.ElderBed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElderBedRepository extends JpaRepository<ElderBed, Long> {
}
