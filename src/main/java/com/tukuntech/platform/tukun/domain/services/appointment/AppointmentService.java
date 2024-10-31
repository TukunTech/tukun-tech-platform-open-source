package com.tukuntech.platform.tukun.domain.services.appointment;

import com.tukuntech.platform.tukun.domain.model.aggregates.appointment.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> GetAllAppointments();
    public abstract Appointment UpdateAndSaveAppointment(Appointment appointment);
    public abstract void DeleteAppointment(Long appointmentId);
}
