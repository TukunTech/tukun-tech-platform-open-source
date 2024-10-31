package com.tukuntech.platform.tukun.interfaces.rest.transform;


import com.tukuntech.platform.tukun.domain.model.aggregates.patient.Patient;
import com.tukuntech.platform.tukun.domain.services.patient.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping( "/v1/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    @ResponseBody  // Se utiliza para retornar datos Json
    public ResponseEntity<List<Patient>> GetAll(){
        List<Patient> list = patientService.GetAllPatients();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/create")
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


    @PutMapping ("/update") //IMPORTANTE PONERLO PUT PARA ACTUALIZAR
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


    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> DeletePatient(@PathVariable("id") long id){
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
