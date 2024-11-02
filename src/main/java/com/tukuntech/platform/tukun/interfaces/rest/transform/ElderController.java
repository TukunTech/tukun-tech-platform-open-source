package com.tukuntech.platform.tukun.interfaces.rest.transform;

import com.tukuntech.platform.tukun.domain.model.aggregates.elder.Elder;
import com.tukuntech.platform.tukun.domain.services.elder.ElderService;
import com.tukuntech.platform.tukun.infrastructure.persistance.jpa.elder.ElderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/elder/v1")
public class ElderController {
    @Autowired
    private ElderService elderService;
    @Autowired
    private ElderRepository elderRepository;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Elder>> getElders() {
        List<Elder> list = elderService.GetElders();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/createelder")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> createPatient(@RequestBody final Elder elder) {
        Map<String,Object> exit = new HashMap<>();
        try{
            elder.setId(0L);
            Elder objExit = elderService.UpdateAndSaveElder(elder);
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

    @PutMapping ("/updateelder")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> updateElder(@RequestBody final Elder elder) {
        Map<String,Object> exit = new HashMap<>();
        try {
            Elder objExit = elderService.UpdateAndSaveElder(elder);
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

    @DeleteMapping("/deletePatient/{id}")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> deletePatient(@PathVariable final long id) {
        Map<String,Object> exit = new HashMap<>();
        try{
            elderService.DeleteElder(id);
            exit.put("message", "Register Correct");
        }
        catch(Exception e){
            e.printStackTrace();
            exit.put("message", "RegisterIncorrect");
        }
        return ResponseEntity.ok(exit);
    }
}
