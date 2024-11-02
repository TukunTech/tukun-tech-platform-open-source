package com.tukuntech.platform.tukun.interfaces.rest.transform;

import com.tukuntech.platform.tukun.domain.model.aggregates.criticalAlerts.CriticalAlerts;
import com.tukuntech.platform.tukun.domain.model.aggregates.pendingMedicine.PendingMedicine;
import com.tukuntech.platform.tukun.domain.services.criticalAlerts.CriticalAlertsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class CriticalAlertsController {

    @Autowired
    private CriticalAlertsService criticalAlertsService;

    @GetMapping("pacientes/{id}/alertas/estado-critico")
    @ResponseBody
    public ResponseEntity<List<CriticalAlerts>> getCriticalAlertsById(@PathVariable("id") int id) {
        List<CriticalAlerts> list = criticalAlertsService.GetAllCriticalAlertsById(id);
        return ResponseEntity.ok(list);
    }


}
