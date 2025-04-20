package com.bootcamp.service.finance.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "debts")
public class DebtModel {

    private String id;
    private String productType;
    private String productId;
    private String customerId;
    private Double creditLimitUsed;
    private Double maintenanceAmount;
    private Double totalAmountPay;
    private LocalDate startInvoicingDate;
    private LocalDate endInvoicingDate;
    private LocalDate paymentDate;
    private String paymentTransactionId;
    private String paymentStatus;
    private String numberPartToPay;

}
