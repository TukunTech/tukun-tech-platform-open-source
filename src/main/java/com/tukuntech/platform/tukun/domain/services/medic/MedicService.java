package com.tukuntech.platform.tukun.domain.services.medic;

import com.tukuntech.platform.tukun.domain.model.aggregates.medic.Medic;

import java.util.List;

public interface MedicService {
    List<Medic> GetAllMedics();
    public abstract Medic UpdateAndSaveMedic(Medic medic);
    public abstract void DeleteMedic(Long medicId);
}
