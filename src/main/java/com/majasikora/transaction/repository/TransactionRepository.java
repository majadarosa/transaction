package com.majasikora.transaction.repository;

import org.springframework.data.repository.CrudRepository;

import com.majasikora.transaction.entity.TransactionEntity;

public interface TransactionRepository extends CrudRepository<TransactionEntity, Long> {}
