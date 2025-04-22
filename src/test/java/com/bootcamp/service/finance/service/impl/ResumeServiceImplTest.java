package com.bootcamp.service.finance.service.impl;

import com.bootcamp.service.finance.mapper.ResumeMapper;
import com.bootcamp.service.finance.model.ResumeModel;
import com.bootcamp.service.finance.model.ResumeRequest;
import com.bootcamp.service.finance.model.ResumeResponse;
import com.bootcamp.service.finance.repository.ResumeRepository;
import com.bootcamp.service.finance.repository.dao.DaoResumeFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class ResumeServiceImplTest {

    @Mock
    DaoResumeFactory daoResumeFactory;

    @Mock
    ResumeRepository resumeRepository;

    @InjectMocks
    ResumeServiceImpl resumeService;

    @Disabled
    @Test
    void shouldSaveResumeModel_whenSaveResumeRequestOfPassiveProduct_thenSuccess() {
        ResumeRequest resumeRequest = new ResumeRequest();
        resumeRequest.setProductType("SA");
        resumeRequest.setProductId("11111111");
        resumeRequest.setCustomerId("AAAAAAA");
        resumeRequest.setTotalAmountInAccount(7000.00);
        resumeRequest.setInformDate(LocalDate.now());

        //resumeRequest.setCreditEnabledToUse(1000.00);
        //resumeRequest.setCreditLimitTotal(2000.00);
        //resumeRequest.setCreditLimitUsed(100.00);

        ResumeModel resumeModel = new ResumeModel();
        resumeModel.setProductId("11111111");
        resumeModel.setCustomerId("AAAAAAA");
        resumeModel.setTotalAmountInAccount(7000.00);
        resumeModel.setInformDate(LocalDate.now());

        ResumeResponse resumeResponse = new ResumeResponse();
        resumeResponse.setProductId("11111111");
        resumeResponse.setCustomerId("AAAAAAA");
        resumeResponse.setTotalAmountInAccount(7000.00);
        resumeResponse.setInformDate(LocalDate.now());

        Mockito.when(daoResumeFactory.getResumeRepository()).thenReturn(resumeRepository);
        Mockito.when(resumeRepository.save(any(ResumeModel.class))).thenReturn(Mono.just(resumeModel));

        Mono<ResumeResponse> result = resumeService.saveResume(Mono.just(resumeRequest));

        StepVerifier
                .create(result)
                .expectNextMatches(resumeResponseResult ->
                        resumeResponseResult.getProductId().equals(resumeRequest.getProductId()))
                .verifyComplete();
    }

    @Disabled
    @Test
    void shouldSaveResumeModel_whenSaveResumeRequestOfActiveProduct_thenSuccess() {
        ResumeRequest resumeRequest = new ResumeRequest();
        resumeRequest.setProductType("SA");
        resumeRequest.setProductId("11111111");
        resumeRequest.setCustomerId("AAAAAAA");
        resumeRequest.setTotalAmountInAccount(7000.00);
        resumeRequest.setInformDate(LocalDate.now());

        //resumeRequest.setCreditEnabledToUse(1000.00);
        //resumeRequest.setCreditLimitTotal(2000.00);
        //resumeRequest.setCreditLimitUsed(100.00);

        ResumeModel resumeModel = new ResumeModel();
        resumeModel.setProductId("11111111");
        resumeModel.setCustomerId("AAAAAAA");
        resumeModel.setTotalAmountInAccount(7000.00);
        resumeModel.setInformDate(LocalDate.now());

        ResumeResponse resumeResponse = new ResumeResponse();
        resumeResponse.setProductId("11111111");
        resumeResponse.setCustomerId("AAAAAAA");
        resumeResponse.setTotalAmountInAccount(7000.00);
        resumeResponse.setInformDate(LocalDate.now());

        Mockito.when(daoResumeFactory.getResumeRepository()).thenReturn(resumeRepository);
        Mockito.when(resumeRepository.save(any(ResumeModel.class))).thenReturn(Mono.just(resumeModel));

        Mono<ResumeResponse> result = resumeService.saveResume(Mono.just(resumeRequest));

        StepVerifier
                .create(result)
                .expectNextMatches(resumeResponseResult ->
                        resumeResponseResult.getProductId().equals(resumeRequest.getProductId()))
                .verifyComplete();
    }




}