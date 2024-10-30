package com.tukuntech.platform.tukun.aplication.doctorImpl;

import com.tukuntech.platform.tukun.domain.model.aggregates.medic.Medic;
import com.tukuntech.platform.tukun.domain.services.medic.MedicService;
import com.tukuntech.platform.tukun.infrastructure.persistance.jpa.medic.MedicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements MedicService {
    @Autowired
    private MedicRepository medicRepository;

    @Override
    public List<Medic> GetAllMedics() {
        return medicRepository.findAll();
    }

    @Override
    public Medic UpdateAndSaveMedic(Medic medic) {
        return medicRepository.save(medic);
    }

    @Override
    public void DeleteMedic(Long medicId) {
        medicRepository.deleteById(medicId);
    }
}
