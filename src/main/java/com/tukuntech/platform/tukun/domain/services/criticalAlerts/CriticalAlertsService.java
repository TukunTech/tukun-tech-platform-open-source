package com.tukuntech.platform.tukun.domain.services.criticalAlerts;

import com.tukuntech.platform.tukun.domain.model.aggregates.criticalAlerts.CriticalAlerts;

import java.util.List;

public interface CriticalAlertsService {
    //GET
    List<CriticalAlerts> GetAllCriticalAlerts();
    //POST
    public abstract CriticalAlerts UpdateAndSaveCriticalAlerts(CriticalAlerts criticalAlerts);
    //DELETE
    public abstract void DeleteCriticalAlerts(long criticalAlertsId);

    List<CriticalAlerts> GetAllCriticalAlertsById(int id);
}
