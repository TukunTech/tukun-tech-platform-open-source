package com.tukuntech.platform.tukun.interfaces.rest.transform;

import com.tukuntech.platform.tukun.domain.model.aggregates.criticalAlerts.TypeAlert;
import com.tukuntech.platform.tukun.domain.model.aggregates.technicalSupport.TechnicalSupport;
import com.tukuntech.platform.tukun.domain.services.criticalAlerts.TypeAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://tukuntech.netlify.app")
@RequestMapping("/api/v1/typeAlerts")
public class TypeAlertsController {
    @Autowired
    private TypeAlertService typeAlertService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<TypeAlert>> GetAllTypeAlerts(){
        List<TypeAlert> list = typeAlertService.GetAllTypeAlerts();
        return ResponseEntity.ok(list);
    }



}
