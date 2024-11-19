package com.tukuntech.platform.tukun.domain.services.elder;

import com.tukuntech.platform.tukun.domain.model.aggregates.patient.MedicalInsurance;

import java.util.List;

public interface MedicalInsuranceService {
    List<MedicalInsurance> getMedicalInsurance();
}
