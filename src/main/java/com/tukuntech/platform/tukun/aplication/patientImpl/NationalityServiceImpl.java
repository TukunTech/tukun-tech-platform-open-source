package com.tukuntech.platform.tukun.aplication.patientImpl;


import com.tukuntech.platform.tukun.domain.model.aggregates.patient.Nationality;
import com.tukuntech.platform.tukun.domain.services.patient.NatonalityService;
import com.tukuntech.platform.tukun.infrastructure.persistance.jpa.patient.NationalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationalityServiceImpl implements NatonalityService {

    @Autowired
    private NationalityRepository nationalityRepository;

    @Override
    public List<Nationality> getNationalities() { return nationalityRepository.findAll();}

}
