package com.example.receivable.receivable.DAO;

import com.example.receivable.receivable.entity.ReceivableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReceivableRepository extends JpaRepository<ReceivableEntity, Long> {
    List<ReceivableEntity> findByName(String name);
}
