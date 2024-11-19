package com.tukuntech.platform.tukun.domain.services.elder;

import com.tukuntech.platform.tukun.domain.model.aggregates.elder.Elder;

import java.util.List;


public interface ElderService {

    //GET
    List<Elder> GetElders();

    //PUT O POST
    public abstract Elder UpdateAndSaveElder(Elder elder);
    //DELETE
    public abstract void DeleteElder(Long elderId);

}
