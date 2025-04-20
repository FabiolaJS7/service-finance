package com.bootcamp.service.finance.service.impl;

import com.bootcamp.service.finance.mapper.DebtMapper;
import com.bootcamp.service.finance.model.DebtRequest;
import com.bootcamp.service.finance.model.DebtResponse;
import com.bootcamp.service.finance.repository.dao.DaoDebtFactory;
import com.bootcamp.service.finance.service.DebtService;
import com.bootcamp.service.finance.util.JsonTransferUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
@AllArgsConstructor
@Slf4j
public class DebtServiceImpl implements DebtService {

    DaoDebtFactory daoDebtFactory;

    @Override
    public Mono<DebtResponse> saveDebt(Mono<DebtRequest> debtRequest) {
        return debtRequest
                .doOnNext(d -> log.info("Saving debt {}", JsonTransferUtil.objectToJson(d)))
                .map(DebtMapper.INSTANCE::getDebtModelOfDebtRequest)
                .flatMap(debtModel -> daoDebtFactory.getDebtRepository().save(debtModel))
                .map(DebtMapper.INSTANCE::getDebtResponseOfDebtModel)
                .doOnSuccess(debtModel -> log.info("Debt saved {}", JsonTransferUtil.objectToJson(debtModel)))
                .doOnError(throwable -> log.error("Error saving debt {}", throwable.getMessage()));
    }

    @Override
    public Flux<DebtResponse> getDebtByProductId(String productId, LocalDate startDate, LocalDate endDate) {
        log.info("Getting all debts by ProductId {} between {},{}", productId, startDate, endDate);
        return daoDebtFactory.getDebtRepository().findDebtModelsByProductIdAndPaymentDateBetween(productId, startDate, endDate)
                .doOnSubscribe(subscription -> log.info("Getting debts for {}", productId))
                .map(DebtMapper.INSTANCE::getDebtResponseOfDebtModel)
                .doOnComplete(() -> log.info("Debt found success for {}", JsonTransferUtil.objectToJson(productId)))
                .doOnError(throwable -> log.error("Error getting debt by productId {}", throwable.getMessage()));

    }


}
