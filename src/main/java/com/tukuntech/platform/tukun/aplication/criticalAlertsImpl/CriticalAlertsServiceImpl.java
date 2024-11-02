package com.tukuntech.platform.tukun.aplication.criticalAlertsImpl;

import com.tukuntech.platform.tukun.domain.model.aggregates.criticalAlerts.CriticalAlerts;
import com.tukuntech.platform.tukun.domain.services.criticalAlerts.CriticalAlertsService;
import com.tukuntech.platform.tukun.infrastructure.persistance.jpa.criticalAlerts.CriticalAlertsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriticalAlertsServiceImpl implements CriticalAlertsService {

    @Autowired
    private CriticalAlertsRepository criticalAlertsRepository;

    @Override
    public List<CriticalAlerts> GetAllCriticalAlerts() {
        return criticalAlertsRepository.findAll();
    }

    @Override
    public CriticalAlerts UpdateAndSaveCriticalAlerts(CriticalAlerts criticalAlerts) {
        return criticalAlertsRepository.save(criticalAlerts);
    }

    @Override
    public void DeleteCriticalAlerts(long criticalAlertsId) {
        criticalAlertsRepository.deleteById(criticalAlertsId);
    }


    @Override
    public List<CriticalAlerts> GetAllCriticalAlertsById(int id) {
        List<CriticalAlerts> criticalAlerts = criticalAlertsRepository.findByType(id);
        return criticalAlerts;
    }



}
