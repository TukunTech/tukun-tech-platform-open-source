package com.tukuntech.platform.tukun.aplication.patientImpl;


import com.tukuntech.platform.tukun.domain.model.aggregates.patient.Bed;
import com.tukuntech.platform.tukun.domain.services.patient.BedService;
import com.tukuntech.platform.tukun.infrastructure.persistance.jpa.patient.BedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BedServiceImpl implements BedService {

    @Autowired
    private BedRepository bedRepository;

    @Override
    public List<Bed> GetAllBed() {
        return bedRepository.findAll();
    }

    @Override
    public Bed UpdateAndSaveBed(Bed bed) {
        return bedRepository.save(bed);
    }

    @Override
    public void DeleteBed(Long bedId) {
        bedRepository.deleteById(bedId);
    }
}
