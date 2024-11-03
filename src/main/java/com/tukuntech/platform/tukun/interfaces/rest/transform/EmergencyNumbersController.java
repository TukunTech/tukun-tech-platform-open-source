package com.tukuntech.platform.tukun.interfaces.rest.transform;


import com.tukuntech.platform.tukun.domain.model.aggregates.emergencyNumbers.EmergencyNumbers;
import com.tukuntech.platform.tukun.domain.services.emergencyNumbers.EmergencyNumbersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/emergencyNumbers/v1")
public class EmergencyNumbersController {

    @Autowired
    private EmergencyNumbersService emergencyNumbersService;

    @GetMapping("elder/{id}/emergency-numbers")
    @ResponseBody
    public ResponseEntity<List<EmergencyNumbers>> getEmergencyNumbersById() {
        List<EmergencyNumbers> list = emergencyNumbersService.GetAllEmergencyNumbers();
        return ResponseEntity.ok(list);
    }

    @PostMapping("elder/{id}/emergency-numbers")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> CreateEmergencyNumbers
            (@PathVariable("id") long elderId, @RequestBody EmergencyNumbers emergencyNumbers) {

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

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> UpdateEmergencyNumbers(@RequestBody EmergencyNumbers emergencyNumbers) {
        Map<String, Object> exit = new HashMap<>();
        try {
            EmergencyNumbers objExit = emergencyNumbersService.UpdateAndSaveEmergencyNumbers(emergencyNumbers);
            if (objExit == null) {
                exit.put("message", "Update error");
            } else {
                exit.put("message", "Update success");
            }

        } catch (Exception e) {
            e.printStackTrace();
            exit.put("message", "Update error");
        }
        return ResponseEntity.ok(exit);
    }

    @DeleteMapping("elder/{id}/emergency-numbers/{emergencyNumbersId}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> DeleteEmergencyNumbers(@PathVariable("id") long emergencyNumbersId) {
        Map<String, Object> exit = new HashMap<>();
        try {
            emergencyNumbersService.DeleteEmergencyNumbers(emergencyNumbersId);
            exit.put("message", "Delete success");
        } catch (Exception e) {
            e.printStackTrace();
            exit.put("message", "Delete error");
        }
        return ResponseEntity.ok(exit);

    }

}
