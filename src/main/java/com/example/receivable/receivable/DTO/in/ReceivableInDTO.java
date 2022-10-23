package com.example.receivable.receivable.DTO.in;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class ReceivableInDTO {

    private String name;
    private Integer accountNumber;
    private LocalDate shipmentDate;
    private Double amount;
    private Integer dayLeft;
}
