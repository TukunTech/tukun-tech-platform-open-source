package com.tukuntech.platform.tukun.aplication.patientImpl;


import com.tukuntech.platform.tukun.domain.model.aggregates.patient.Patient;
import com.tukuntech.platform.tukun.domain.services.patient.PatientService;
import com.tukuntech.platform.tukun.infrastructure.persistance.jpa.patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


// Aca conectamos lo que hicimos en el servicio con el Jpa(Repository)

@Service // Esta notacion Declaramos que toda la clase es un SERVICIO
public class PatientServiceImpl implements PatientService {

    @Autowired // Indica que esto va ser lo primero en cargar
    private PatientRepository patientRepository;

    // Metodo para listar todo
    @Override
    public List<Patient> GetAllPatients() {
        return patientRepository.findAll();
    }

    // Metodo para Actualizar o Guardar data
    @Override
    public Patient UpdateAndSavePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    // Metodo para Eliminar por ID(por boton, angular lo hace)
    @Override
    public void DeletePatient(Long patientId) {
        patientRepository.deleteById(patientId);
    }

}
