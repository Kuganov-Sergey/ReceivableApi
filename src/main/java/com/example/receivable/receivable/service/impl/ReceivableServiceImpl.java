package com.example.receivable.receivable.service.impl;

import com.example.receivable.receivable.DAO.ReceivableRepository;
import com.example.receivable.receivable.DTO.in.ReceivableInDTO;
import com.example.receivable.receivable.DTO.out.ReceivableOutDTO;
import com.example.receivable.receivable.entity.ReceivableEntity;
import com.example.receivable.receivable.exception.ReceivableEntityNotFountException;
import com.example.receivable.receivable.mapper.ReceivableMapper;
import com.example.receivable.receivable.service.ReceivableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceivableServiceImpl implements ReceivableService {

    private final ReceivableRepository receivableRepository;

    @Autowired
    public ReceivableServiceImpl(ReceivableRepository receivableRepository) {
        this.receivableRepository = receivableRepository;
    }

    @Override
    public List<ReceivableOutDTO> findAll() {
        List<ReceivableEntity> receivableEntities = receivableRepository.findAll();
        return receivableEntities.stream().map(ReceivableMapper.RECEIVABLE_MAPPER::
                receivableEntityToReceivableOutDTO).toList();
    }

    @Override
    public ReceivableOutDTO getById(Long id) throws ReceivableEntityNotFountException {
        Optional<ReceivableEntity> byId = receivableRepository.findById(id);
        if (byId.isEmpty()) {
            throw new ReceivableEntityNotFountException();
        }
        return ReceivableMapper.RECEIVABLE_MAPPER.receivableEntityToReceivableOutDTO(byId.get());
    }

    @Override
    public Long create(ReceivableInDTO receivable, Integer countDays) {
        ReceivableEntity receivableEntity =
                ReceivableMapper.RECEIVABLE_MAPPER.receivableOutDTOToReceivableEntity(receivable);
        receivableEntity.setPaymentDate(receivable.getShipmentDate().plusDays(countDays));
        receivableRepository.save(receivableEntity);
        return receivableEntity.getId();
    }

    @Override
    public Long deleteById(Long id) {
        receivableRepository.deleteById(id);
        return id;
    }

    @Override
    public void updateById(Long id) {

    }

    @Override
    public List<ReceivableOutDTO> findByName(String name) {
        List<ReceivableEntity> receivableEntities = receivableRepository.findByName(name);
        return receivableEntities.stream().map(ReceivableMapper.RECEIVABLE_MAPPER::
                receivableEntityToReceivableOutDTO).toList();
    }
}
