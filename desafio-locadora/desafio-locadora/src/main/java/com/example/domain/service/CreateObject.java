package com.example.domain.service;

import com.example.domain.entity.CarroModel;
import com.example.domain.entity.MotoristaModel;

import javax.sql.rowset.CachedRowSet;
import java.util.List;

public interface CreateObject {
    public Object createMotorista(MotoristaModel motoristaModel);

    public List<CarroModel> listarCarros();
}
