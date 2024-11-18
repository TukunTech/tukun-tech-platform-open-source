package com.tukuntech.platform.tukun.domain.services.criticalAlerts;

import com.tukuntech.platform.tukun.domain.model.aggregates.criticalAlerts.TypeAlert;

import java.util.List;

public interface TypeAlertService {
    List<TypeAlert> GetAllTypeAlerts();
}
