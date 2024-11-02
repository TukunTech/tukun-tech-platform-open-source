package com.tukuntech.platform.tukun.infrastructure.persistance.jpa.elder;
import com.tukuntech.platform.tukun.domain.model.aggregates.elder.Elder;
import com.tukuntech.platform.tukun.domain.model.aggregates.elder.Elder;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ElderRepository extends JpaRepository<Elder, Long> {
}
