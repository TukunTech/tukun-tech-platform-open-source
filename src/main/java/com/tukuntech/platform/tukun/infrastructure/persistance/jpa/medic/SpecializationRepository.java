package com.tukuntech.platform.tukun.infrastructure.persistance.jpa.medic;

import com.tukuntech.platform.tukun.domain.model.aggregates.medic.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecializationRepository extends JpaRepository <Specialization, Long> {

}
