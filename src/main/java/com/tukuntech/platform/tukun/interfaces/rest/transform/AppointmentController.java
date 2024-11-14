package com.tukuntech.platform.tukun.interfaces.rest.transform;

import com.tukuntech.platform.tukun.domain.model.aggregates.appointment.Appointment;
import com.tukuntech.platform.tukun.domain.services.appointment.AppointmentService;
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

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/appointments", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Appointment", description = "Available Appointment Endpoints")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    @Operation(summary = "Get all appointments", description = "Get all appointments")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Appointments found"),
            @ApiResponse(responseCode = "404", description = "Appointments not found")
    })
    @ResponseBody
    public ResponseEntity<List<Appointment>> GetAll(){
        List<Appointment> list = appointmentService.GetAllAppointments();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    @Operation(summary = "Create a new appointment", description = "Create a new appointment")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Appointment created"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
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

    @PutMapping("/{appointmentId}")
    @Operation(summary = "Update an appointment", description = "Update an appointment")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Appointment updated"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
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

    @DeleteMapping("/{appointmentId}")
    @Operation(summary = "Delete an appointment", description = "Delete an appointment")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Appointment deleted"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
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
