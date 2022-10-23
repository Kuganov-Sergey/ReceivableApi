package com.example.receivable.receivable.DTO.out;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class ReceivableOutDTO {

    private Long id;
    private String name;
    private Integer accountNumber;
    private LocalDate shipmentDate;
    private LocalDate paymentDate;
    private Double amount;
    private Integer dayLeft;
}
