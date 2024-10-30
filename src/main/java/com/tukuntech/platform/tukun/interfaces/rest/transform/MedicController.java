package com.tukuntech.platform.tukun.interfaces.rest.transform;

import com.tukuntech.platform.tukun.domain.model.aggregates.medic.Medic;
import com.tukuntech.platform.tukun.domain.services.medic.MedicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/medic/v1")
public class MedicController {

    @Autowired
    private MedicService medicService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Medic>> GetAll(){
        List<Medic> list = medicService.GetAllMedics();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/createmedic")
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

    @PutMapping("/updatemedic")
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

    @DeleteMapping("/deletemedic/{id}")
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
