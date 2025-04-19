package com.bootcamp.service.finance.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "resumes")
public class ResumeModel {

    @Id
     private String id;
     private String result;
     private String productType;
     private String productId;
     private String customerId;
     private Double creditEnabledToUse;
     private Double creditLimitTotal;
     private Double creditLimitUsed;
     private Double totalAmountInAccount;
     private LocalDate informDate;

}
