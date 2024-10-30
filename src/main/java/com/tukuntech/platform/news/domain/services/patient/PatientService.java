package com.tukuntech.platform.news.domain.services.patient;

import java.util.List;
import com.tukuntech.platform.news.domain.model.aggregates.patient.Patient;

public interface PatientService {
    // Vamos a declarar aqui los metodos

    // Metodo para listar todos los pacientes
    List<Patient> GetAllPatients();

    // Metodo Actualizar o Crear paciente
    public abstract Patient UpdateAndSavePatient(Patient patient); // este metodo recibe un objeto paciente de la clase paciente

    // Metodo Eliminar
    public abstract void DeletePatient(Long patientId);
}
