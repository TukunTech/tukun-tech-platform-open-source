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
@RequestMapping(value = "/clinicalHistory/v1", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "ClinicalHistory", description = "Available Clinical History Endpoints")
public class ClinicalHistoryController {

    @Autowired
    private ClinicalHistoryService clinicalHistoryService;

    @GetMapping
    @Operation(summary = "Get all clinical histories", description = "Retrieve all clinical histories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Clinical histories found"),
            @ApiResponse(responseCode = "404", description = "Clinical histories not found")
    })
    @ResponseBody
    public ResponseEntity<List<ClinicalHistory>> getAll() {
        List<ClinicalHistory> list = clinicalHistoryService.getAllClinicalHistories();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    @Operation(summary = "Create a new clinical history", description = "Create a new clinical history entry")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Clinical history created"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @ResponseBody
    public ResponseEntity<Map<String, Object>> create(@RequestBody ClinicalHistory clinicalHistory) {
        Map<String, Object> response = new HashMap<>();
        try {
            clinicalHistory.setId(0L);
            ClinicalHistory savedClinicalHistory = clinicalHistoryService.updateAndSaveClinicalHistory(clinicalHistory);
            response.put("message", savedClinicalHistory == null ? "Register Incorrect" : "Register Correct");
        } catch (Exception e) {
            e.printStackTrace();
            response.put("message", "Register Incorrect");
        }
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{clinicalHistoryId}")
    @Operation(summary = "Update a clinical history", description = "Update an existing clinical history entry")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Clinical history updated"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Clinical history not found")
    })
    @ResponseBody
    public ResponseEntity<Map<String, Object>> update(@PathVariable("clinicalHistoryId") Long id, @RequestBody ClinicalHistory clinicalHistory) {
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

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a clinical history", description = "Delete a clinical history entry by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Clinical history deleted"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Clinical history not found")
    })
    @ResponseBody
    public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") Long id) {
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

