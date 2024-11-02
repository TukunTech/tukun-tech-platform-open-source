package com.tukuntech.platform.tukun.domain.services.pendingMedicine;

import com.tukuntech.platform.tukun.domain.model.aggregates.pendingMedicine.PendingMedicine;

import java.util.List;

public interface PendingMedicineService {
    List<PendingMedicine> GetAllPendingMedicines();
    public abstract PendingMedicine UpdateAndSavePendingMedicine(PendingMedicine pendingMedicine);
    public abstract void DeletePendingMedicine(int pendingMedicineId);
}
