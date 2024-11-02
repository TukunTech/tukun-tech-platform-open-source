package com.tukuntech.platform.tukun.aplication.elderImpl;
import com.tukuntech.platform.tukun.domain.model.aggregates.elder.Elder;
import com.tukuntech.platform.tukun.domain.services.elder.ElderService;
import com.tukuntech.platform.tukun.infrastructure.persistance.jpa.elder.ElderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
//Elder
@Service
public class ElderServiceImpl implements ElderService {

    @Autowired
    private ElderRepository elderRepository;

    @Override
    public List<Elder> GetElders(){ return elderRepository.findAll();}

    @Override
    public Elder UpdateAndSaveElder(Elder elder) {return elderRepository.save(elder);}

    @Override
    public void DeleteElder(Long patientId){elderRepository.deleteById(patientId);}

}
