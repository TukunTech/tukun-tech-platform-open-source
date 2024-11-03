package com.tukuntech.platform.tukun.aplication.elderImpl;


import com.tukuntech.platform.tukun.domain.model.aggregates.elder.ElderBed;
import com.tukuntech.platform.tukun.domain.services.elder.ElderBedService;
import com.tukuntech.platform.tukun.infrastructure.persistance.jpa.elder.ElderBedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElderBedServiceImpl implements ElderBedService {

    @Autowired
    private ElderBedRepository elderbedRepository;

    @Override
    public List<ElderBed> GetAllElderBed() {
        return elderbedRepository.findAll();
    }

    @Override
    public ElderBed UpdateAndSaveElderBed(ElderBed elderbed) {
        return elderbedRepository.save(elderbed);
    }

    @Override
    public void DeleteElderBed(Long bedId) {
        elderbedRepository.deleteById(bedId);
    }
}
