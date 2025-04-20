package com.bootcamp.service.finance.mapper;

import com.bootcamp.service.finance.model.DebtModel;
import com.bootcamp.service.finance.model.DebtRequest;
import com.bootcamp.service.finance.model.DebtResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DebtMapper {

    DebtMapper INSTANCE = Mappers.getMapper(DebtMapper.class);

    DebtModel getDebtModelOfDebtRequest(DebtRequest debtRequest);
    DebtResponse getDebtResponseOfDebtModel(DebtModel debtModel);
}
