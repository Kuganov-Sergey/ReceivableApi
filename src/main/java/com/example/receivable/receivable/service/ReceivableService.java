package com.example.receivable.receivable.service;

import com.example.receivable.receivable.DTO.in.ReceivableInDTO;
import com.example.receivable.receivable.DTO.out.ReceivableOutDTO;
import com.example.receivable.receivable.exception.ReceivableEntityNotFountException;

import java.util.List;

public interface ReceivableService {
    List<ReceivableOutDTO> findAll();
    List<ReceivableOutDTO> findByName(String name);
    ReceivableOutDTO getById(Long id) throws ReceivableEntityNotFountException;
    Long create(ReceivableInDTO receivable, Integer countDays);
    Long deleteById(Long id);
    void updateById(Long id);
}
