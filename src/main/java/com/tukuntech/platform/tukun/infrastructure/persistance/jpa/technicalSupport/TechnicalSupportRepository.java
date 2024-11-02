package com.tukuntech.platform.tukun.infrastructure.persistance.jpa.technicalSupport;

import com.tukuntech.platform.tukun.domain.model.aggregates.technicalSupport.TechnicalSupport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicalSupportRepository extends JpaRepository<TechnicalSupport, Integer> {
}
