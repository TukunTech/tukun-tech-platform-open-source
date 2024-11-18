package com.tukuntech.platform.tukun.domain.services.pendingMedicine;

import com.tukuntech.platform.tukun.domain.model.aggregates.pendingMedicine.Status;

import java.util.List;

public interface StatusService {
    List<Status> getStatus();
}
