package com.tukuntech.platform.tukun.interfaces.rest.transform;

import com.tukuntech.platform.tukun.domain.model.aggregates.appointment.Appointment;
import com.tukuntech.platform.tukun.domain.services.appointment.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/appointment/v1")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Appointment>> GetAll(){
        List<Appointment> list = appointmentService.GetAllAppointments();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/createAppointment")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> CreateAppointment(@RequestBody Appointment appointment){
        Map<String, Object> response = new HashMap<>();
        try{
            appointment.setId(0L);
            Appointment savedAppointment = appointmentService.UpdateAndSaveAppointment(appointment);
            response.put("message", savedAppointment == null ? "Register Incorrect" : "Register Correct");
        } catch(Exception e){
            e.printStackTrace();
            response.put("message", "Register Incorrect");
        }
        return ResponseEntity.ok(response);
    }

    @PutMapping("/updateAppointment")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> UpdateAppointment(@RequestBody Appointment appointment){
        Map<String, Object> response = new HashMap<>();
        try{
            Appointment updatedAppointment = appointmentService.UpdateAndSaveAppointment(appointment);
            response.put("message", updatedAppointment == null ? "Update Incorrect" : "Update Correct");
        } catch(Exception e){
            e.printStackTrace();
            response.put("message", "Update Incorrect");
        }
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/deleteAppointment/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> DeleteAppointment(@PathVariable("id") long id){
        Map<String, Object> response = new HashMap<>();
        try{
            appointmentService.DeleteAppointment(id);
            response.put("message", "Delete Correct");
        } catch(Exception e){
            e.printStackTrace();
            response.put("message", "Delete Incorrect");
        }
        return ResponseEntity.ok(response);
    }
}
