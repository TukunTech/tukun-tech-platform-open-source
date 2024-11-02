package com.tukuntech.platform.tukun.interfaces.rest.transform;

import com.tukuntech.platform.tukun.domain.model.aggregates.patient.Bed;
import com.tukuntech.platform.tukun.domain.model.aggregates.technicalSupport.TechnicalSupport;
import com.tukuntech.platform.tukun.domain.services.technicalSupport.TechnicalSupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/soporte")
public class TechnicalSupportController {
    @Autowired
    private TechnicalSupportService technicalSupportService;

    @GetMapping("/faqs")
    @ResponseBody
    public ResponseEntity<List<TechnicalSupport>> GetAll(){
        List<TechnicalSupport> list = technicalSupportService.GetAllTechnicalSupports();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/mensaje")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> CreateTechnicalSupport(@RequestBody TechnicalSupport technicalSupport){
            Map<String, Object> exit = new HashMap<>();
            try {
                technicalSupport.setId(0);
                TechnicalSupport objExit = technicalSupportService.UpdateAndSaveTechnicalSupport(technicalSupport);
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





}
