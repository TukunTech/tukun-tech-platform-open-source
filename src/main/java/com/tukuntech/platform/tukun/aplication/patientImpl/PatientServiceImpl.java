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

    @Autowired
    private PatientRepository patientRepository;


    @Override
    public List<Patient> GetAllPatients() { return patientRepository.findAll(); }

    @Override
    public Patient UpdateAndSavePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void DeletePatient(Long patientId) { patientRepository.deleteById(patientId); }

}
