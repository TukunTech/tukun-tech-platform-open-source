package com.tukuntech.platform.tukun.domain.services.medic;

import com.tukuntech.platform.tukun.domain.model.aggregates.medic.Specialization;

import java.util.List;

public interface SpecializationService {
    List<Specialization> getSpecialization();
}
