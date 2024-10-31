package com.tukuntech.platform.tukun.infrastructure.persistance.jpa.appointment;

import com.tukuntech.platform.tukun.domain.model.aggregates.appointment.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
