package com.bootcamp.service.finance.expose;


import com.bootcamp.service.finance.api.ApiApiDelegate;
import com.bootcamp.service.finance.model.ResumeRequest;
import com.bootcamp.service.finance.model.ResumeResponse;
import com.bootcamp.service.finance.service.ResumeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;


@Service
@Slf4j
@AllArgsConstructor
public class ServiceFinanceDelegateImpl implements ApiApiDelegate {

    ResumeService resumeService;

    @Override
    public Mono<ResponseEntity<ResumeResponse>> saveResume(Mono<ResumeRequest> resumeRequest,
                                                           ServerWebExchange exchange) {
        log.info(" -> Init save resume.");
        return resumeRequest
                .flatMap(request -> resumeService.saveResume(Mono.just(request)))
                .map(ResponseEntity::ok)
                .doOnSuccess(response -> log.info(" -> End save resume response: {}", response))
                .onErrorResume(e -> Mono.just(new ResponseEntity<>(HttpStatus.BAD_REQUEST)));
    }

    @Override
    public Mono<ResponseEntity<Flux<ResumeResponse>>> getResumesByProductId(String productId,
                                                                             LocalDate startDate,
                                                                             LocalDate endDate,
                                                                             ServerWebExchange exchange) {
        log.info("-> Init getResumesByProductId {}, {}, {}", productId, startDate, endDate);
        return Mono.just(ResponseEntity.ok(resumeService.getAllResumes(productId, startDate, endDate)));
    }

}
