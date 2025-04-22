package com.bootcamp.service.finance.expose;

import com.bootcamp.service.finance.model.ResumeRequest;
import com.bootcamp.service.finance.model.ResumeResponse;
import com.bootcamp.service.finance.service.ResumeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@SpringBootTest
class ServiceFinanceDelegateImplTest {

    @Autowired
    ResumeService resumeService;

    @Disabled
    @Test
    void saveResume() {
        ResumeRequest resumeRequest = new ResumeRequest();
        resumeRequest.setProductType("SA");
        resumeRequest.setProductId("11111111");
        resumeRequest.setCustomerId("AAAAAAA");
        resumeRequest.setTotalAmountInAccount(7000.00);
        resumeRequest.setInformDate(LocalDate.now());

        Mono<ResumeResponse> resumeResponseMono = resumeService.saveResume(Mono.just(resumeRequest));

        Assertions.assertNotNull(resumeResponseMono);
    }

    @Disabled
    @Test
    void shoulGetResume_whenSendProductIdAndDates_thenSuccess() {
        String productId = "1231312312312";
        LocalDate  endDate = LocalDate.now();
        LocalDate startDate = LocalDate.now().minusDays(5);

        Flux<ResumeResponse> resumeResponseFlux = resumeService.getAllResumes(productId, startDate, endDate);

        Assertions.assertNotNull(resumeResponseFlux);
        Assertions.assertEquals(1, resumeResponseFlux.count().block());
    }
}