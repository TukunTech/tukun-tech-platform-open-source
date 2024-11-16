package com.tukuntech.platform.tukun.infrastructure.persistance.jpa.patient;

import com.tukuntech.platform.tukun.domain.model.aggregates.patient.Gender;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GenderRepository extends JpaRepository<Gender, Long> {

}
