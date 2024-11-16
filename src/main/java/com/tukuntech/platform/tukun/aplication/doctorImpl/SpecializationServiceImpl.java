package com.tukuntech.platform.tukun.aplication.doctorImpl;

import com.tukuntech.platform.tukun.domain.model.aggregates.medic.Specialization;
import com.tukuntech.platform.tukun.domain.services.medic.SpecializationService;
import com.tukuntech.platform.tukun.infrastructure.persistance.jpa.medic.SpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecializationServiceImpl implements SpecializationService {
    @Autowired
    private SpecializationRepository specializationRepository;

    @Override
    public List<Specialization> getSpecialization(){
        return specializationRepository.findAll();
    }
}
