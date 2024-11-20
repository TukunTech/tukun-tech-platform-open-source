package com.tukuntech.platform.tukun.interfaces.rest.transform;


import com.tukuntech.platform.tukun.domain.model.aggregates.patient.Patient;
import com.tukuntech.platform.tukun.domain.services.patient.PatientService;
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

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/patients", produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "https://tukuntech.netlify.app")
@Tag(name = "Patient", description = "Available Patient Endpoints")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/patients")
    @Operation(summary = "Get all patients", description = "Get all patients")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Patients found"),
            @ApiResponse(responseCode = "404", description = "Patients not found")
    })
    @ResponseBody  // Se utiliza para retornar datos Json
    public ResponseEntity<List<Patient>> GetAll(){
        List<Patient> list = patientService.GetAllPatients();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    @Operation(summary = "Create a new patients", description = "Create a new patients")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Patients created"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @ResponseBody
    public ResponseEntity<Map<String, Object>> CreatePatient(@RequestBody Patient patient){
        Map<String, Object> exit = new HashMap<>();
        try {
            patient.setId(0L); // El "L" permite trasformar el LONG en un Int , otro metodo para hacerlo es este : obj.setIdEstudiante(Long.valueOf(0));
            Patient objExit = patientService.UpdateAndSavePatient(patient);
            if(objExit == null){
                exit.put("message", "Register Incorrect");
            } else {
                exit.put("message", "Register Correct");
            }
        }
        catch(Exception e){
            e.printStackTrace();
            exit.put("message", "RegisterIncorrect");
        }
        return ResponseEntity.ok(exit);
    }


    @PutMapping ("/{patientId}") //IMPORTANTE PONERLO PUT PARA ACTUALIZAR
    @Operation(summary = "Update a patient", description = "Update a patient")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Patient updated"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Patient not found")
    })
    @ResponseBody
    public ResponseEntity<Map<String, Object>> UpdatePatient(@RequestBody Patient patient){
        Map<String, Object> exit = new HashMap<>();
        try {
            Patient objExit = patientService.UpdateAndSavePatient(patient);
            if(objExit == null){
                exit.put("message", "Update Incorrect");
            } else {
                exit.put("message", "Update Correct");
            }
        }
        catch(Exception e){
            e.printStackTrace();
            exit.put("message", " Update Incorrect");
        }
        return ResponseEntity.ok(exit);
    }


    @DeleteMapping("/{patientId}")
    @Operation(summary = "Delete a patient", description = "Delete a patient")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Patient deleted"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Patient not found")
    })
    @ResponseBody
    public ResponseEntity<Map<String, Object>> DeletePatient(@PathVariable("patientId") long id){
        Map<String, Object> exit = new HashMap<>();
        try {
            patientService.DeletePatient(id);
            exit.put("message", "Delete Correct");
        }
        catch (Exception e){
            e.printStackTrace();
            exit.put("message", " Delete Incorrect");
        }
        return ResponseEntity.ok(exit);

    }

}
