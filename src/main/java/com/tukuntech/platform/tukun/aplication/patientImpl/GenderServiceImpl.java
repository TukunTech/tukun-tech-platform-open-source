package com.tukuntech.platform.tukun.aplication.patientImpl;


import com.tukuntech.platform.tukun.domain.model.aggregates.patient.Gender;
import com.tukuntech.platform.tukun.domain.services.patient.GenderService;
import com.tukuntech.platform.tukun.infrastructure.persistance.jpa.patient.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderServiceImpl implements GenderService {

    @Autowired
    private GenderRepository genderRepository;

    @Override
    public List<Gender> getGenders() {
        return genderRepository.findAll();
    }
}
