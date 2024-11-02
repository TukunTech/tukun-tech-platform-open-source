package com.tukuntech.platform.tukun.infrastructure.persistance.jpa.pendingMedicine;

import com.tukuntech.platform.tukun.domain.model.aggregates.pendingMedicine.PendingMedicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PendingMedicineRepository extends JpaRepository<PendingMedicine, Integer> {
}
