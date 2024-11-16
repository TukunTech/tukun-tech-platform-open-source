package com.tukuntech.platform.tukun.domain.services.patient;

import com.tukuntech.platform.tukun.domain.model.aggregates.patient.Gender;

import java.util.List;

public interface GenderService {
  List<Gender> getGenders();
}
