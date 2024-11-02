package com.tukuntech.platform.tukun.domain.services.elder;

import java.util.List;
import com.tukuntech.platform.tukun.domain.model.aggregates.elder.Elder;


public interface ElderService {

    //GET
    List<Elder> GetElders();

    //PUT O POST
    public abstract Elder UpdateAndSaveElder(Elder elder);
    //DELETE
    public abstract void DeleteElder(Long elderId);

}
