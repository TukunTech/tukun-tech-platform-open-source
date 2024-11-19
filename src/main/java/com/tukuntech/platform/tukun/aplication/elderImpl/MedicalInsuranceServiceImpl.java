package com.tukuntech.platform.tukun.aplication.elderImpl;

import com.tukuntech.platform.tukun.domain.model.aggregates.patient.MedicalInsurance;
import com.tukuntech.platform.tukun.domain.services.elder.MedicalInsuranceService;
import com.tukuntech.platform.tukun.infrastructure.persistance.jpa.elder.MedicalInsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalInsuranceServiceImpl implements MedicalInsuranceService {

    @Autowired
    private MedicalInsuranceRepository medicalInsuranceRepository;

    @Override
    public List<MedicalInsurance> getMedicalInsurance() {
        return medicalInsuranceRepository.findAll();
    }
}
