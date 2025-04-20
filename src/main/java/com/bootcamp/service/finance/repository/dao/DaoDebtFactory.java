package com.bootcamp.service.finance.repository.dao;

import com.bootcamp.service.finance.repository.DebtRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DaoDebtFactory {

    private final DebtRepository debtRepository;

    public DebtRepository getDebtRepository() {
        return debtRepository;
    }
}
