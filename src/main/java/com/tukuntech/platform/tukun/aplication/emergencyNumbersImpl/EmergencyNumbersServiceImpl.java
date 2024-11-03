package com.tukuntech.platform.tukun.aplication.emergencyNumbersImpl;

import com.tukuntech.platform.tukun.domain.model.aggregates.emergencyNumbers.EmergencyNumbers;
import com.tukuntech.platform.tukun.domain.services.emergencyNumbers.EmergencyNumbersService;
import com.tukuntech.platform.tukun.infrastructure.persistance.jpa.emergencyNumbers.EmergencyNumbersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmergencyNumbersServiceImpl implements EmergencyNumbersService {
    @Autowired
    private EmergencyNumbersRepository emergencyNumbersRepository;

    @Override
    public List<EmergencyNumbers> GetAllEmergencyNumbers() { return emergencyNumbersRepository.findAll(); }

    @Override
    public EmergencyNumbers UpdateAndSaveEmergencyNumbers(EmergencyNumbers emergencyNumbers) { return emergencyNumbersRepository.save(emergencyNumbers); }

    @Override
    public void DeleteEmergencyNumbers(Long emergencyNumbersId) { emergencyNumbersRepository.deleteById(emergencyNumbersId); }

}
