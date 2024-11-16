package com.tukuntech.platform.tukun.interfaces.rest.transform;

import com.tukuntech.platform.tukun.domain.model.aggregates.elder.ElderBed;
import com.tukuntech.platform.tukun.domain.services.elder.ElderBedService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/elder-bed", produces = APPLICATION_JSON_VALUE)
@Tag(name = "ElderBed", description = "Available ElderBed Endpoints")
public class ElderBedController {

    @Autowired
    private ElderBedService elderBedService;

    @GetMapping
    @Operation(summary = "Get all elder beds", description = "Retrieve a list of all elder beds")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Elder beds retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "No elder beds found")
    })
    public ResponseEntity<List<ElderBed>> getAllElderBeds() {
        List<ElderBed> list = elderBedService.GetAllElderBed();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    @Operation(summary = "Create a new elder bed", description = "Register a new elder bed in the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Elder bed created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    public ResponseEntity<Map<String, Object>> createElderBed(@RequestBody ElderBed elderBed) {
        Map<String, Object> response = new HashMap<>();
        try {
            elderBed.setId(0L); // Set ID to 0 to ensure it's treated as a new record
            ElderBed createdElderBed = elderBedService.UpdateAndSaveElderBed(elderBed);
            if (createdElderBed == null) {
                response.put("message", "Register error");
            } else {
                response.put("message", "Register success");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.put("message", "Register error");
        }
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an elder bed", description = "Update details of an existing elder bed")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Elder bed updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Elder bed not found")
    })
    public ResponseEntity<Map<String, Object>> updateElderBed(@PathVariable("id") long id, @RequestBody ElderBed elderBed) {
        Map<String, Object> response = new HashMap<>();
        try {
            elderBed.setId(id); // Set ID to ensure the correct record is updated
            ElderBed updatedElderBed = elderBedService.UpdateAndSaveElderBed(elderBed);
            if (updatedElderBed == null) {
                response.put("message", "Update error");
            } else {
                response.put("message", "Update success");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.put("message", "Update error");
        }
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an elder bed", description = "Remove an elder bed from the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Elder bed deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Elder bed not found")
    })
    public ResponseEntity<Map<String, Object>> deleteElderBed(@PathVariable("id") long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            elderBedService.DeleteElderBed(id);
            response.put("message", "Delete success");
        } catch (Exception e) {
            e.printStackTrace();
            response.put("message", "Delete error");
        }
        return ResponseEntity.ok(response);
    }
}
