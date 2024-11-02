package com.tukuntech.platform.tukun.infrastructure.persistance.jpa.criticalAlerts;

import com.tukuntech.platform.tukun.domain.model.aggregates.criticalAlerts.CriticalAlerts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CriticalAlertsRepository extends JpaRepository<CriticalAlerts, Long> {
    List<CriticalAlerts> findByType(int id);
}
