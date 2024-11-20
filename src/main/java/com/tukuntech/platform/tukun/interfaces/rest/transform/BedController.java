package com.tukuntech.platform.tukun.interfaces.rest.transform;


import com.tukuntech.platform.tukun.domain.model.aggregates.patient.Bed;
import com.tukuntech.platform.tukun.domain.services.patient.BedService;
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

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/bed", produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "https://tukuntech.netlify.app")
@Tag(name = "Bed", description = "Available Bed Endpoints")
public class BedController {

    @Autowired
    private BedService bedService;

    @GetMapping
    @Operation(summary = "Get all beds", description = "Get all beds")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Beds found"),
            @ApiResponse(responseCode = "404", description = "Beds not found")
    })
    @ResponseBody
    public ResponseEntity<List<Bed>> GetAll(){
        List<Bed> list = bedService.GetAllBed();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    @Operation(summary = "Create a new bed", description = "Create a new bed")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Bed created"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
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


    @PutMapping("/{bedId}")
    @Operation(summary = "Update a bed", description = "Update a bed")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bed updated"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Bed not found")
    })
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


    @DeleteMapping("/{bedId}")
    @Operation(summary = "Delete a bed", description = "Delete a bed")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bed deleted"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Bed not found")
    })
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
