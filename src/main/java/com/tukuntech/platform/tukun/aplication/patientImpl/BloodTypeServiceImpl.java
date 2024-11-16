package com.tukuntech.platform.tukun.aplication.patientImpl;


import com.tukuntech.platform.tukun.domain.model.aggregates.patient.BloodType;
import com.tukuntech.platform.tukun.domain.services.patient.BloodTypeService;
import com.tukuntech.platform.tukun.infrastructure.persistance.jpa.patient.BloodTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloodTypeServiceImpl implements BloodTypeService {


    @Autowired
    private BloodTypeRepository bloodTypeRepository;

    @Override
    public List<BloodType> getBloodType() {
        return bloodTypeRepository.findAll();
    }

}
