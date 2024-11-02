package com.tukuntech.platform.tukun.domain.services.technicalSupport;

import com.tukuntech.platform.tukun.domain.model.aggregates.technicalSupport.TechnicalSupport;

import java.util.List;

public interface TechnicalSupportService {
    List<TechnicalSupport> GetAllTechnicalSupports();
    public abstract TechnicalSupport UpdateAndSaveTechnicalSupport(TechnicalSupport technicalSupport);
    public abstract void DeleteTechnicalSupport(int technicalSupportId);

}
