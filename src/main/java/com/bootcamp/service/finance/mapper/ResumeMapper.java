package com.bootcamp.service.finance.mapper;

import com.bootcamp.service.finance.model.ResumeModel;
import com.bootcamp.service.finance.model.ResumeRequest;
import com.bootcamp.service.finance.model.ResumeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ResumeMapper {

    ResumeMapper INSTANCE = Mappers.getMapper(ResumeMapper.class);

    ResumeModel getResumeModelOfResumeRequest(ResumeRequest resumeRequest);
    ResumeResponse getResumeResponseOfResumeModel(ResumeModel resumeModel);

}
