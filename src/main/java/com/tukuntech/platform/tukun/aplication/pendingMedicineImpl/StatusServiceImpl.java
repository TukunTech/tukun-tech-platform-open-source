package com.tukuntech.platform.tukun.aplication.pendingMedicineImpl;

import com.tukuntech.platform.tukun.domain.model.aggregates.pendingMedicine.Status;
import com.tukuntech.platform.tukun.domain.services.pendingMedicine.StatusService;
import com.tukuntech.platform.tukun.infrastructure.persistance.jpa.pendingMedicine.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public List<Status> getStatus(){return statusRepository.findAll();}


}
