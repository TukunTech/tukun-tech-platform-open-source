package com.tukuntech.platform.tukun.aplication.criticalAlertsImpl;

import com.tukuntech.platform.tukun.domain.model.aggregates.criticalAlerts.TypeAlert;
import com.tukuntech.platform.tukun.domain.services.criticalAlerts.TypeAlertService;
import com.tukuntech.platform.tukun.infrastructure.persistance.jpa.criticalAlerts.TypeAlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeAlertServiceImpl implements TypeAlertService {
    @Autowired
    private TypeAlertRepository typeAlertRepository;

    @Override
    public List<TypeAlertService> GetAllTypeAlerts() {
        return List.of();
    }
}
