package com.tukuntech.platform.tukun.aplication.pendingMedicineImpl;

import com.tukuntech.platform.tukun.domain.model.aggregates.pendingMedicine.PendingMedicine;
import com.tukuntech.platform.tukun.domain.services.pendingMedicine.PendingMedicineService;
import com.tukuntech.platform.tukun.infrastructure.persistance.jpa.pendingMedicine.PendingMedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PendingMedicineServiceImpl implements PendingMedicineService {

    @Autowired
    private PendingMedicineRepository pendingMedicineRepository;

    @Override
    public List<PendingMedicine> GetAllPendingMedicines() {
        return pendingMedicineRepository.findAll();
    }

    @Override
    public PendingMedicine UpdateAndSavePendingMedicine(PendingMedicine pendingMedicine) {
        return pendingMedicineRepository.save(pendingMedicine);
    }

    @Override
    public void DeletePendingMedicine(int pendingMedicineId) {
        pendingMedicineRepository.deleteById(pendingMedicineId);
    }
}
