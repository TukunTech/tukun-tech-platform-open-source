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
@CrossOrigin(origins = "*") // Configura los orígenes permitidos según tu necesidad
@RequestMapping("/pendingMedicine/v1")
public class PendingMedicineController {

    @Autowired
    private PendingMedicineService pendingMedicineService;

    @GetMapping("/pendingMedicines")
    @ResponseBody
    public ResponseEntity<List<PendingMedicine>> GetAll(){
        List<PendingMedicine> list = pendingMedicineService.GetAllPendingMedicines();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Map<String, Object>> CreatePendingMedicine
            (@RequestBody PendingMedicine pendingMedicine){

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

    @PutMapping("/{pendingMedicineId}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> updatePendingMedicine(
            @PathVariable int pendingMedicineId,
            @RequestBody PendingMedicine pendingMedicine) {
        Map<String, Object> exit = new HashMap<>();
        try {
            pendingMedicine.setId(pendingMedicineId);
            PendingMedicine objExit = pendingMedicineService.UpdateAndSavePendingMedicine(pendingMedicine);

            if (objExit == null) {
                exit.put("message", "Register error");
            } else {
                exit.put("message", "Register success");
                exit.put("data", objExit);
            }
        } catch (Exception e) {
            e.printStackTrace();
            exit.put("message", "Register error");
            exit.put("error", e.getMessage());
        }
        return ResponseEntity.ok(exit);
    }


    @DeleteMapping("/{pendingMedicineId}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> deletePendingMedicine(
            @PathVariable("pendingMedicineId") int pendingMedicineId) {
        Map<String, Object> exit = new HashMap<>();
        try {
            pendingMedicineService.DeletePendingMedicine(pendingMedicineId);
            exit.put("message", "Delete success");
        } catch (Exception e) {
            e.printStackTrace();
            exit.put("message", "Delete error");
            exit.put("error", e.getMessage());
        }
        return ResponseEntity.ok(exit);
    }

}
