package com.tukuntech.platform.tukun.interfaces.rest.transform;

import com.tukuntech.platform.tukun.domain.model.aggregates.elder.Elder;
import com.tukuntech.platform.tukun.domain.services.elder.ElderService;
import com.tukuntech.platform.tukun.infrastructure.persistance.jpa.elder.ElderRepository;
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
@RequestMapping(value = "/api/v1/elders", produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*") // Configura los orígenes permitidos según tu necesidad
@Tag(name = "Elder", description = "Available Elder Endpoints")
public class ElderController {

    @Autowired
    private ElderService elderService;

    @Autowired
    private ElderRepository elderRepository;

    @GetMapping
    @Operation(summary = "Get all elders", description = "Retrieve a list of all elders")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Elders retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "No elders found")
    })
    public ResponseEntity<List<Elder>> getElders() {
        List<Elder> list = elderService.GetElders();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    @Operation(summary = "Create a new elder", description = "Register a new elder in the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Elder created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    public ResponseEntity<Map<String, Object>> createElder(@RequestBody Elder elder) {
        Map<String, Object> response = new HashMap<>();
        try {
            elder.setId(0L); // Ensure the ID is reset for new creation
            Elder createdElder = elderService.UpdateAndSaveElder(elder);
            if (createdElder == null) {
                response.put("message", "Register Incorrect");
            } else {
                response.put("message", "Register Correct");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.put("message", "Register Incorrect");
        }
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing elder", description = "Update the details of an existing elder")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Elder updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Elder not found")
    })
    public ResponseEntity<Map<String, Object>> updateElder(@PathVariable("id") long id, @RequestBody Elder elder) {
        Map<String, Object> response = new HashMap<>();
        try {
            elder.setId(id); // Set the ID to ensure the correct entity is updated
            Elder updatedElder = elderService.UpdateAndSaveElder(elder);
            if (updatedElder == null) {
                response.put("message", "Update Incorrect");
            } else {
                response.put("message", "Update Correct");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.put("message", "Update Incorrect");
        }
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an elder", description = "Remove an elder from the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Elder deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Elder not found")
    })
    public ResponseEntity<Map<String, Object>> deleteElder(@PathVariable long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            elderService.DeleteElder(id);
            response.put("message", "Delete Correct");
        } catch (Exception e) {
            e.printStackTrace();
            response.put("message", "Delete Incorrect");
        }
        return ResponseEntity.ok(response);
    }
}
