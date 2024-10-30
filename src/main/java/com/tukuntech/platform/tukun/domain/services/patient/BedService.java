package com.tukuntech.platform.tukun.domain.services.patient;

import com.tukuntech.platform.tukun.domain.model.aggregates.patient.Bed;

import java.util.List;

public interface BedService {

    List<Bed> GetAllBed();
    public abstract Bed UpdateAndSaveBed(Bed bed); // este metodo recibe un objeto paciente de la clase paciente
    public abstract void DeleteBed(Long bedId);
}
