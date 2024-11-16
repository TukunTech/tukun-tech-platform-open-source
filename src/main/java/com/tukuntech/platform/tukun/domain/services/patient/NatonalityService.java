package com.tukuntech.platform.tukun.domain.services.patient;

import com.tukuntech.platform.tukun.domain.model.aggregates.patient.Nationality;

import java.util.List;

public interface NatonalityService {
    List<Nationality> getNationalities();
}
