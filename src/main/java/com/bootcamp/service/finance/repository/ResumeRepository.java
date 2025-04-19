package com.bootcamp.service.finance.repository;

import com.bootcamp.service.finance.model.ResumeModel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

@Repository
public interface ResumeRepository extends ReactiveMongoRepository<ResumeModel, String> {
    Flux<ResumeModel> findResumeModelsByProductIdAndInformDateBetween(String productId, LocalDate informDateAfter, LocalDate informDateBefore);
}
