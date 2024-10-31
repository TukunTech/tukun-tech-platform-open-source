package com.tukuntech.platform.tukun.domain.services.patient;

import java.util.List;
import com.tukuntech.platform.tukun.domain.model.aggregates.patient.Patient;

public interface PatientService {

    List<Patient> GetAllPatients();
    public abstract Patient UpdateAndSavePatient(Patient patient); // este metodo recibe un objeto paciente de la clase paciente
    public abstract void DeletePatient(Long patientId);
}
