package com.bootcamp.service.finance.repository;

import com.bootcamp.service.finance.model.DebtModel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

public interface DebtRepository extends ReactiveMongoRepository<DebtModel, Long> {

    Flux<DebtModel> findDebtModelsByProductIdAndPaymentDateBetween(String productId, LocalDate paymentDateAfter, LocalDate paymentDateBefore);
}
