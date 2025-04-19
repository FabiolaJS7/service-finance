package com.bootcamp.service.finance.repository.dao;

import com.bootcamp.service.finance.repository.ResumeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class DaoResumeFactory {

    private final ResumeRepository resumeRepository;

    public ResumeRepository getResumeRepository() {
        return resumeRepository;
    }

}
