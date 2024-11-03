package com.tukuntech.platform.tukun.infrastructure.persistance.jpa.emergencyNumbers;

import com.tukuntech.platform.tukun.domain.model.aggregates.emergencyNumbers.EmergencyNumbers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmergencyNumbersRepository extends JpaRepository <EmergencyNumbers, Long> {
}
