package com.tukuntech.platform.tukun.aplication.appointmentImpl;

import com.tukuntech.platform.tukun.domain.model.aggregates.appointment.Appointment;
import com.tukuntech.platform.tukun.domain.services.appointment.AppointmentService;
import com.tukuntech.platform.tukun.infrastructure.persistance.jpa.appointment.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Override
    public List<Appointment> GetAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment UpdateAndSaveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public void DeleteAppointment(Long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }


}
