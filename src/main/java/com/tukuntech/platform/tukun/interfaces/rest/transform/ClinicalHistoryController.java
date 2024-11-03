package com.tukuntech.platform.tukun.interfaces.rest.transform;

import com.tukuntech.platform.tukun.domain.model.aggregates.clinicalHistory.ClinicalHistory;
import com.tukuntech.platform.tukun.domain.services.patientHistory.ClinicalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clinicalHistory/v1")
public class ClinicalHistoryController {

    @Autowired
    private ClinicalHistoryService clinicalHistoryService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<ClinicalHistory>> getAll() {
        List<ClinicalHistory> list = clinicalHistoryService.getAllClinicalHistories();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/createClinicalHistory")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> createClinicalHistory(@RequestBody ClinicalHistory clinicalHistory) {
        Map<String, Object> response = new HashMap<>();
        try {
            clinicalHistory.setId(0L);  // Assuming ID should be 0 for a new entry
            ClinicalHistory savedClinicalHistory = clinicalHistoryService.updateAndSaveClinicalHistory(clinicalHistory);
            response.put("message", savedClinicalHistory == null ? "Register Incorrect" : "Register Correct");
        } catch (Exception e) {
            e.printStackTrace();
            response.put("message", "Register Incorrect");
        }
        return ResponseEntity.ok(response);
    }

    @PutMapping("/updateClinicalHistory")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> updateClinicalHistory(@RequestBody ClinicalHistory clinicalHistory) {
        Map<String, Object> response = new HashMap<>();
        try {
            ClinicalHistory updatedClinicalHistory = clinicalHistoryService.updateAndSaveClinicalHistory(clinicalHistory);
            response.put("message", updatedClinicalHistory == null ? "Update Incorrect" : "Update Correct");
        } catch (Exception e) {
            e.printStackTrace();
            response.put("message", "Update Incorrect");
        }
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/deleteClinicalHistory/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> deleteClinicalHistory(@PathVariable("id") Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            clinicalHistoryService.deleteClinicalHistory(id);
            response.put("message", "Delete Correct");
        } catch (Exception e) {
            e.printStackTrace();
            response.put("message", "Delete Incorrect");
        }
        return ResponseEntity.ok(response);
    }
}
