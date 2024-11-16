package com.tukuntech.platform.tukun.domain.services.patient;

import com.tukuntech.platform.tukun.domain.model.aggregates.patient.BloodType;
import com.tukuntech.platform.tukun.infrastructure.persistance.jpa.patient.BloodTypeRepository;

import java.util.List;

public interface BloodTypeService {
    List<BloodType> getBloodType();
}
