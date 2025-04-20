package com.bootcamp.service.finance.service;

import com.bootcamp.service.finance.model.DebtRequest;
import com.bootcamp.service.finance.model.DebtResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

public interface DebtService {

    Mono<DebtResponse> saveDebt(Mono<DebtRequest> debtRequest);
    Flux<DebtResponse> getDebtByProductId(String productId, LocalDate startDate, LocalDate endDate);
}
