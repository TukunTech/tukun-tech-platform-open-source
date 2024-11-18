package com.tukuntech.platform.tukun.infrastructure.persistance.jpa.criticalAlerts;

import com.tukuntech.platform.tukun.domain.model.aggregates.criticalAlerts.TypeAlert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeAlertRepository extends JpaRepository<TypeAlert, Integer> {
}
