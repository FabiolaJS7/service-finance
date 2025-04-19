package com.bootcamp.service.finance.service;

import com.bootcamp.service.finance.model.ResumeRequest;
import com.bootcamp.service.finance.model.ResumeResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

public interface ResumeService {

    Mono<ResumeResponse> saveResume(Mono<ResumeRequest> request);
    Flux<ResumeResponse> getAllResumes(String productId, LocalDate startDate, LocalDate endDate);
}
