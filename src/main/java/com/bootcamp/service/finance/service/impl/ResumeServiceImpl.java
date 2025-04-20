package com.bootcamp.service.finance.service.impl;

import com.bootcamp.service.finance.mapper.ResumeMapper;
import com.bootcamp.service.finance.model.ResumeRequest;
import com.bootcamp.service.finance.model.ResumeResponse;
import com.bootcamp.service.finance.repository.dao.DaoResumeFactory;
import com.bootcamp.service.finance.service.ResumeService;
import com.bootcamp.service.finance.util.JsonTransferUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
@Slf4j
@AllArgsConstructor
public class ResumeServiceImpl implements ResumeService {

    DaoResumeFactory daoResumeFactory;

    @Override
    public Mono<ResumeResponse> saveResume(Mono<ResumeRequest> request) {
        return request
                .doOnNext(subscription -> log.info("Saving resume {}", request))
                .map(ResumeMapper.INSTANCE::getResumeModelOfResumeRequest)
                .flatMap(resumeModel -> daoResumeFactory.getResumeRepository().save(resumeModel)
                        .doOnSuccess(resume -> log.info("Saved resume model {}",
                                JsonTransferUtil.objectToJson(resume)))
                        .map(ResumeMapper.INSTANCE::getResumeResponseOfResumeModel))
                .map(resumeResponse -> {
                     resumeResponse.setResult(Boolean.TRUE.toString());
                     return resumeResponse;
                })
                .doOnSuccess(resumeModelMono -> log.info("Save resume success {}",
                        JsonTransferUtil.objectToJson(resumeModelMono)))
                .doOnError(throwable -> log.error("Error save resume {}", throwable.getMessage()));
    }

    @Override
    public Flux<ResumeResponse> getAllResumes(String productId, LocalDate startDate, LocalDate endDate) {
        log.info("Getting all resumes by productId {} between {}, {}", productId, startDate, endDate);
        return daoResumeFactory.getResumeRepository().findResumeModelsByProductIdAndInformDateBetween(productId, startDate, endDate)
                .doOnSubscribe(subscription -> log.info("Getting resumes for {}", productId))
                .map(ResumeMapper.INSTANCE::getResumeResponseOfResumeModel)
                .doOnComplete(() -> log.info("Getting resumes success for {}", productId))
                .doOnError(throwable -> log.error("Error getting resumes for {}, {}, {}", productId, startDate, endDate));
    }
}
