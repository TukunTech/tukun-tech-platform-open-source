package com.tukuntech.platform.tukun.domain.services.elder;

import com.tukuntech.platform.tukun.domain.model.aggregates.patient.Allergy;

import java.util.List;

public interface AllergyService {
    List<Allergy> getAllergy();
}
