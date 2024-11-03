package com.tukuntech.platform.tukun.interfaces.rest.transform;


import com.tukuntech.platform.tukun.domain.model.aggregates.elder.ElderBed;
import com.tukuntech.platform.tukun.domain.services.elder.ElderBedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping( "/v1/elder-bed")
public class ElderBedController {

    @Autowired
    private ElderBedService elderbedService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<ElderBed>> GetAll(){
        List<ElderBed> list = elderbedService.GetAllElderBed();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> CreateElderBed(@RequestBody ElderBed elderbed){
        Map<String, Object> exit = new HashMap<>();
        try {

            elderbed.setId(0L);
            ElderBed objExit = elderbedService.UpdateAndSaveElderBed(elderbed);
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
    public ResponseEntity<Map<String, Object>> UpdateBed(@RequestBody ElderBed elderbed){
        Map<String, Object> exit = new HashMap<>();
        try {
            ElderBed objExit = elderbedService.UpdateAndSaveElderBed(elderbed);
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


    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> DeleteElderBed(@PathVariable("id") long id){
        Map<String, Object> exit = new HashMap<>();
        try {
            elderbedService.DeleteElderBed(id);
            exit.put("message", "Delete success");
        }
        catch(Exception e){
            e.printStackTrace();
            exit.put("message", "Delete error");
        }
        return ResponseEntity.ok(exit);
    }

}
