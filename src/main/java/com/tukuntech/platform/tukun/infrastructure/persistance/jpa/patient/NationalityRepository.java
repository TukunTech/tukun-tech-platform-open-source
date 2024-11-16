package com.tukuntech.platform.tukun.infrastructure.persistance.jpa.patient;

import com.tukuntech.platform.tukun.domain.model.aggregates.patient.Nationality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NationalityRepository extends JpaRepository<Nationality, Long> {
}
