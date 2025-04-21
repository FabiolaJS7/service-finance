package com.bootcamp.service.finance.mapper;

import com.bootcamp.service.finance.model.DebtModel;
import com.bootcamp.service.finance.model.DebtRequest;
import com.bootcamp.service.finance.model.DebtResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DebtMapper {

    DebtMapper INSTANCE = Mappers.getMapper(DebtMapper.class);

    @Mapping(source = "maintanceAmount", target = "maintenanceAmount")
    @Mapping(source = "totalAmountToPay", target = "totalAmountPay")
    DebtModel getDebtModelOfDebtRequest(DebtRequest debtRequest);

    @Mapping(source = "maintenanceAmount", target = "maintanceAmount")
    @Mapping(source = "totalAmountPay", target = "totalAmountToPay")
    DebtResponse getDebtResponseOfDebtModel(DebtModel debtModel);
}
