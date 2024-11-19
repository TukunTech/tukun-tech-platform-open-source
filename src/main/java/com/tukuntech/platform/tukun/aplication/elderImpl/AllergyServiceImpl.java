package com.tukuntech.platform.tukun.aplication.elderImpl;

import com.tukuntech.platform.tukun.domain.model.aggregates.patient.Allergy;
import com.tukuntech.platform.tukun.domain.services.elder.AllergyService;
import com.tukuntech.platform.tukun.infrastructure.persistance.jpa.elder.AllergyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllergyServiceImpl implements AllergyService {

    @Autowired
    private AllergyRepository allergyRepository;

    @Override
    public List<Allergy> getAllergy() {
        return allergyRepository.findAll();
    }
}
