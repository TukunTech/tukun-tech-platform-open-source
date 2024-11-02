package com.tukuntech.platform.tukun.interfaces.rest.transform;

import com.tukuntech.platform.tukun.domain.model.aggregates.patient.Bed;
import com.tukuntech.platform.tukun.domain.model.aggregates.pendingMedicine.PendingMedicine;
import com.tukuntech.platform.tukun.domain.services.patient.BedService;
import com.tukuntech.platform.tukun.domain.services.pendingMedicine.PendingMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/adultos-mayores")
public class PendingMedicineController {

    @Autowired
    private PendingMedicineService pendingMedicineService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<PendingMedicine>> GetAll(){
        List<PendingMedicine> list = pendingMedicineService.GetAllPendingMedicines();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/{id}/medicamentos-pendientes")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> CreatePendingMedicine
            (@PathVariable("id") long elderId, @RequestBody PendingMedicine pendingMedicine){

        Map<String, Object> exit = new HashMap<>();
        try {
            pendingMedicine.setId(0);
            PendingMedicine objExit = pendingMedicineService.UpdateAndSavePendingMedicine(pendingMedicine);
            if(objExit == null){
                exit.put("message", "Register error");
            }
            else {
                exit.put("message", "Register success");
            }

        }

        catch(Exception e){
            e.printStackTrace();
            exit.put("message", "Register error");
        }
        return ResponseEntity.ok(exit);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> UpdatePendingMedicine(@RequestBody PendingMedicine pendingMedicine){
        Map<String, Object> exit = new HashMap<>();
        try {
            PendingMedicine objExit = pendingMedicineService.UpdateAndSavePendingMedicine(pendingMedicine);
            if(objExit == null){
                exit.put("message", "Register error");
            }
            else {
                exit.put("message", "Register success");
            }
        }
        catch(Exception e){
            e.printStackTrace();
            exit.put("message", "Register error");
        }
        return ResponseEntity.ok(exit);
    }

    @DeleteMapping("/{elderId}/medicamentos-pendientes/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> DeletePendingMedicine(@PathVariable("id") int id){
        Map<String, Object> exit = new HashMap<>();
        try {
            pendingMedicineService.DeletePendingMedicine(id);
            exit.put("message", "Delete success");
        }
        catch(Exception e){
            e.printStackTrace();
            exit.put("message", "Delete error");
        }
        return ResponseEntity.ok(exit);
    }


}
