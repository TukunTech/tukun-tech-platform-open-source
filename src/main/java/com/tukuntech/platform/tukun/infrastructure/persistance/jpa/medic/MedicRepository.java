package com.tukuntech.platform.tukun.infrastructure.persistance.jpa.medic;

import com.tukuntech.platform.tukun.domain.model.aggregates.medic.Medic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicRepository extends JpaRepository <Medic, Long> {
}
