package com.tukuntech.platform.tukun.aplication.technicalSupportImpl;

import com.tukuntech.platform.tukun.domain.model.aggregates.pendingMedicine.PendingMedicine;
import com.tukuntech.platform.tukun.domain.model.aggregates.technicalSupport.TechnicalSupport;
import com.tukuntech.platform.tukun.domain.services.technicalSupport.TechnicalSupportService;
import com.tukuntech.platform.tukun.infrastructure.persistance.jpa.technicalSupport.TechnicalSupportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicalSupportImpl implements TechnicalSupportService {

    @Autowired
    private TechnicalSupportRepository technicalSupportRepository;

    @Override
    public List<TechnicalSupport> GetAllTechnicalSupports() {
        return technicalSupportRepository.findAll();    }

    @Override
    public TechnicalSupport UpdateAndSaveTechnicalSupport(TechnicalSupport technicalSupport) {
        return technicalSupportRepository.save(technicalSupport);
    }

    @Override
    public void DeleteTechnicalSupport(int technicalSupportId) {
        technicalSupportRepository.deleteById(technicalSupportId);

    }
}
