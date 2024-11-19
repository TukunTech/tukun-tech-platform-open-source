package com.tukuntech.platform.tukun.interfaces.rest.transform;


import com.tukuntech.platform.tukun.domain.model.aggregates.emergencyNumbers.EmergencyNumbers;
import com.tukuntech.platform.tukun.domain.services.emergencyNumbers.EmergencyNumbersService;
import com.tukuntech.platform.tukun.domain.util.appSetings;
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

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin(origins = appSetings.URL_CROSS_ORIGIN)
@RequestMapping(value ="/emergencyNumbers/v1", produces = APPLICATION_JSON_VALUE)
@Tag(name = "EmergencyNumbers", description = "Available EmergencyNumbers Endpoints")
public class EmergencyNumbersController {

    @Autowired
    private EmergencyNumbersService emergencyNumbersService;

    @GetMapping("/emergencyNumbers")
    @Operation(summary = "Get all emergency numbers", description = "Get all emergency numbers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Emergency number found"),
            @ApiResponse(responseCode = "404", description = "Emergency number not found")
    })
    @ResponseBody
    public ResponseEntity<List<EmergencyNumbers>> GetAll() {
        List<EmergencyNumbers> list = emergencyNumbersService.GetAllEmergencyNumbers();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    @Operation(summary = "Create a new emergency number", description = "Create a new emergency number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Emergency number created"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @ResponseBody
    public ResponseEntity<Map<String, Object>> CreateEmergencyNumbers
            (@RequestBody EmergencyNumbers emergencyNumbers) {
        Map<String, Object> exit = new HashMap<>();
        try {
            emergencyNumbers.setId(0L);
            EmergencyNumbers objExit = emergencyNumbersService.UpdateAndSaveEmergencyNumbers(emergencyNumbers);
            if (objExit == null) {
                exit.put("message", "Register error");
            } else {
                exit.put("message", "Register success");
            }

        } catch (Exception e) {
            e.printStackTrace();
            exit.put("message", "Register error");
        }
        return ResponseEntity.ok(exit);
    }

    @PutMapping("/{emergencyNumbersId}")
    @Operation(summary = "Update a emergency number", description = "Update a emergency number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "emergency number updated"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "emergency number not found")
    })
    @ResponseBody
    public ResponseEntity<Map<String, Object>> UpdateEmergencyNumbers(
            @PathVariable long emergencyNumbersId,
            @RequestBody EmergencyNumbers emergencyNumbers) {
        Map<String, Object> exit = new HashMap<>();
        try {
            emergencyNumbers.setId(emergencyNumbersId);
            EmergencyNumbers objExit = emergencyNumbersService.UpdateAndSaveEmergencyNumbers(emergencyNumbers);
            if (objExit == null) {
                exit.put("message", "Register error");
            } else {
                exit.put("message", "Register success");
            }

        } catch (Exception e) {
            e.printStackTrace();
            exit.put("message", "Register error");
            exit.put("error", e.getMessage());
        }
        return ResponseEntity.ok(exit);
    }

    @DeleteMapping("/{emergencyNumbersId}")
    @Operation(summary = "Delete a emergency number", description = "Delete a emergency number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Emergency number deleted"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Emergency number not found")
    })
    @ResponseBody
    public ResponseEntity<Map<String, Object>> DeleteEmergencyNumbers(
            @PathVariable("emergencyNumbersId") long emergencyNumbersId) {
        Map<String, Object> exit = new HashMap<>();
        try {
            emergencyNumbersService.DeleteEmergencyNumbers(emergencyNumbersId);
            exit.put("message", "Delete success");
        } catch (Exception e) {
            e.printStackTrace();
            exit.put("message", "Delete error");
            exit.put("error", e.getMessage());
        }
        return ResponseEntity.ok(exit);

    }

}
