package com.tukuntech.platform.tukun.infrastructure.persistance.jpa.clinicalHistory;

import com.tukuntech.platform.tukun.domain.model.aggregates.clinicalHistory.ClinicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicalHistoryRepository extends JpaRepository<ClinicalHistory, Long> {

}
