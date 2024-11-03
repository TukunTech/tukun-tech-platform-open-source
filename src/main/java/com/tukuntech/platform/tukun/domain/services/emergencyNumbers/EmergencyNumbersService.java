package com.tukuntech.platform.tukun.domain.services.emergencyNumbers;

import com.tukuntech.platform.tukun.domain.model.aggregates.emergencyNumbers.EmergencyNumbers;

import java.util.List;

public interface EmergencyNumbersService {
    List<EmergencyNumbers> GetAllEmergencyNumbers();
    public abstract EmergencyNumbers UpdateAndSaveEmergencyNumbers(EmergencyNumbers emergencyNumbers);
    public abstract void DeleteEmergencyNumbers(Long emergencyNumbersId);

}
