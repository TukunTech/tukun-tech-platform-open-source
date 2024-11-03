package com.tukuntech.platform.tukun.domain.services.patientHistory;

import com.tukuntech.platform.tukun.domain.model.aggregates.clinicalHistory.ClinicalHistory;

import java.util.List;

public interface ClinicalHistoryService {
    List<ClinicalHistory> getAllClinicalHistories();
    ClinicalHistory updateAndSaveClinicalHistory(ClinicalHistory clinicalHistory);
    void deleteClinicalHistory(Long clinicalHistoryId);
}
