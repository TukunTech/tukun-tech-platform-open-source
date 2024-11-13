package com.tukuntech.platform.tukun.interfaces.rest.transform;

import com.tukuntech.platform.tukun.domain.model.aggregates.medic.Medic;
import com.tukuntech.platform.tukun.domain.services.medic.MedicService;
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
@RequestMapping(value = "/api/v1/medics", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Medic", description = "Available Medic Endpoints")
public class MedicController {

    @Autowired
    private MedicService medicService;

    @GetMapping("/medics")
    @Operation(summary = "Get all medics", description = "Get all medics")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Medics found"),
            @ApiResponse(responseCode = "404", description = "Medics not found")
    })
    @ResponseBody
    public ResponseEntity<List<Medic>> GetAll(){
        List<Medic> list = medicService.GetAllMedics();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    @Operation(summary = "Create a new medic", description = "Create a new medic")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Medic created"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @ResponseBody
    public ResponseEntity<Map<String, Object>> CreateMedic(@RequestBody Medic medic){
        Map<String, Object> exit = new HashMap<>();
        try{
            medic.setId(0L);
            Medic objExit = medicService.UpdateAndSaveMedic(medic);
            if(objExit == null){
                exit.put("message", "Register Incorrect");
            } else {
                exit.put("message", "Register Correct");
            }
        }
        catch(Exception e){
            e.printStackTrace();
            exit.put("message", "Register Incorrect");
        }
        return ResponseEntity.ok(exit);
    }

    @PutMapping("/{medicId}")
    @Operation(summary = "Update a medic", description = "Update a medic")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Medic updated"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Medic not found")
    })
    @ResponseBody
    public ResponseEntity<Map<String, Object>> UpdateMedic(@RequestBody Medic medic){
        Map<String, Object> exit = new HashMap<>();
        try{
            Medic objExit = medicService.UpdateAndSaveMedic(medic);
            if(objExit == null){
                exit.put("message", "Update Incorrect");
            } else {
                exit.put("message", "Update Correct");
            }
        }
        catch(Exception e){
            e.printStackTrace();
            exit.put("message", "Update Incorrect");
        }
        return ResponseEntity.ok(exit);
    }

    @DeleteMapping("/{medicId}")
    @Operation(summary = "Delete a medic", description = "Delete a medic")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Medic deleted"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Medic not found")
    })
    @ResponseBody
    public ResponseEntity<Map<String, Object>> DeleteMedic(@PathVariable("id") long id){
        Map<String, Object> exit = new HashMap<>();
        try{
            medicService.DeleteMedic(id);
            exit.put("message", "Delete Correct");
        }
        catch(Exception e){
            e.printStackTrace();
            exit.put("message", "Delete Incorrect");
        }
        return ResponseEntity.ok(exit);
    }
}
