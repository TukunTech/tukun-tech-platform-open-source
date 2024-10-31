package com.tukuntech.platform.tukun.interfaces.rest.transform;


import com.tukuntech.platform.tukun.domain.model.aggregates.patient.Bed;
import com.tukuntech.platform.tukun.domain.services.patient.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping( "/v1/bed")
public class BedController {

    @Autowired
    private BedService bedService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Bed>> GetAll(){
        List<Bed> list = bedService.GetAllBed();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> CreateBed(@RequestBody Bed bed){
        Map<String, Object> exit = new HashMap<>();
        try {
           bed.setId(0L);
           Bed objExit = bedService.UpdateAndSaveBed(bed);
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
    public ResponseEntity<Map<String, Object>> UpdateBed(@RequestBody Bed bed){
        Map<String, Object> exit = new HashMap<>();
        try {
            Bed objExit = bedService.UpdateAndSaveBed(bed);
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
    public ResponseEntity<Map<String, Object>> DeleteBed(@PathVariable("id") long id){
        Map<String, Object> exit = new HashMap<>();
        try {
            bedService.DeleteBed(id);
            exit.put("message", "Delete success");
        }
        catch(Exception e){
            e.printStackTrace();
            exit.put("message", "Delete error");
        }
        return ResponseEntity.ok(exit);
    }

}
