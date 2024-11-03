package com.tukuntech.platform.tukun.domain.services.elder;

import com.tukuntech.platform.tukun.domain.model.aggregates.elder.ElderBed;

import java.util.List;

public interface ElderBedService {

    List<ElderBed> GetAllElderBed();
    public abstract ElderBed UpdateAndSaveElderBed(ElderBed bed);
    public abstract void DeleteElderBed(Long bedId);
}
