package com.tukuntech.platform.tukun.infrastructure.persistance.jpa.pendingMedicine;

import com.tukuntech.platform.tukun.domain.model.aggregates.pendingMedicine.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Integer> {
}
