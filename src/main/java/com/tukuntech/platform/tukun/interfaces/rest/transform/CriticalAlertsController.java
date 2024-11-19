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
@RequestMapping("/api/v1//criticalAlert")
public class CriticalAlertsController {

    @Autowired
    private CriticalAlertsService criticalAlertsService;

    @GetMapping("/criticalAlerts")
    @ResponseBody
    public ResponseEntity<List<CriticalAlerts>> getAllCriticalAlerts() {
        List<CriticalAlerts> list = criticalAlertsService.GetAllCriticalAlerts();
        return ResponseEntity.ok(list);
    }
}
