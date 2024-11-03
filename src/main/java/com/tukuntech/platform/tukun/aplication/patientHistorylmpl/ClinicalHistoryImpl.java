package com.tukuntech.platform.tukun.aplication.patientHistorylmpl;

import com.tukuntech.platform.tukun.domain.model.aggregates.clinicalHistory.ClinicalHistory;
import com.tukuntech.platform.tukun.domain.services.patientHistory.ClinicalHistoryService;
import com.tukuntech.platform.tukun.infrastructure.persistance.jpa.clinicalHistory.ClinicalHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicalHistoryImpl implements ClinicalHistoryService {

    @Autowired
    private ClinicalHistoryRepository clinicalHistoryRepository;

    @Override
    public List<ClinicalHistory> getAllClinicalHistories() {
        return clinicalHistoryRepository.findAll();
    }

    @Override
    public ClinicalHistory updateAndSaveClinicalHistory(ClinicalHistory clinicalHistory) {
        return clinicalHistoryRepository.save(clinicalHistory);
    }

    @Override
    public void deleteClinicalHistory(Long clinicalHistoryId) {
        clinicalHistoryRepository.deleteById(clinicalHistoryId);
    }
}
