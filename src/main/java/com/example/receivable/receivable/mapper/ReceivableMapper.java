package com.example.receivable.receivable.mapper;

import com.example.receivable.receivable.DTO.in.ReceivableInDTO;
import com.example.receivable.receivable.DTO.out.ReceivableOutDTO;
import com.example.receivable.receivable.entity.ReceivableEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReceivableMapper {

    ReceivableMapper RECEIVABLE_MAPPER = Mappers.getMapper(ReceivableMapper.class);

    ReceivableOutDTO receivableEntityToReceivableOutDTO(ReceivableEntity receivable);

    @Mapping(target = "paymentDate", ignore = true)
    @Mapping(target = "id", ignore = true)
    ReceivableEntity receivableOutDTOToReceivableEntity(ReceivableInDTO receivable);
}
