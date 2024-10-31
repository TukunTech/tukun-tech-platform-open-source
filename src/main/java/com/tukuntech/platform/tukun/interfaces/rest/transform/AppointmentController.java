package com.tukuntech.platform.tukun.interfaces.rest.transform;

import com.tukuntech.platform.tukun.domain.model.aggregates.appointment.Appointment;
import com.tukuntech.platform.tukun.domain.services.appointment.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    //TODO: Falta PUT, DELETE, POST
}
